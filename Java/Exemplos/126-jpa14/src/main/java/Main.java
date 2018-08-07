import com.cursojava.entity.Cidade;
import com.cursojava.entity.Estado;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            /*Query query = entityManager.createQuery(
                    "select c from Cidade c order by c.nome",
                    Cidade.class
            );
            List<Cidade> cidades = query.getResultList();
            show(cidades);*/

            /*Query queryNew = entityManager.createQuery(
                    "select new Cidade(c.nome, c.habitantes) from Cidade c order by c.nome",
                    Cidade.class
            );
            List<Cidade> cidades2 = queryNew.getResultList();*/

            List<Cidade> cidades2 = entityManager.createNamedQuery("Cidade.Todas", Cidade.class)
                    .getResultList();
            show(cidades2);

            List<Cidade> cidades3 = entityManager.createNamedQuery("Cidade.PorEstado", Cidade.class)
                    .setParameter("estado", new Estado(1L))
                    .getResultList();
            show(cidades3);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void show(List<Cidade> cidades) {
        for (Cidade cidade: cidades) {
            out.print(cidade);
        }
    }
}
