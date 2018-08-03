package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author CPB
 *
 */
public class Corredor extends Thread implements Comparable<Corredor> {

	protected int chegada;
	protected int distanciaPercorrida;
	protected long tempoDeCorrida;

	protected boolean comSono;

	public Corredor(int chegada, boolean comSono) {
		this.chegada = chegada;
		this.comSono = comSono;

		this.distanciaPercorrida = 0;
		this.tempoDeCorrida = 0;
	}

	public Corredor(int chegada) {
		this(chegada, false);
	}

	public void run() {

		long inicio = System.currentTimeMillis();

		Random r = new Random();
		while (this.distanciaPercorrida < this.chegada) {
			if (this.comSono && r.nextBoolean()) {
				try {
					Thread.sleep(r.nextInt(10) + 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			++this.distanciaPercorrida;
			System.out.println("\t Corredor de ID nº" + this.getId() + "\t percorreu " + this.distanciaPercorrida
					+ ",\t faltando " + (this.chegada - this.distanciaPercorrida) + " para a chegada em sua corrida de "
					+ this.chegada + ".");
		}
		long fim = System.currentTimeMillis();

		this.tempoDeCorrida = fim - inicio;

		System.out.println("\t Corredor de ID nº" + this.getId() + "\t CHEGOU na linha de chegada levando "
				+ this.tempoDeCorrida + "ms!");
	}

	public boolean chegou() {
		return this.distanciaPercorrida >= this.chegada;
	}

	@Override
	public int compareTo(Corredor outro) {
		int ret = 0;
		if (outro.chegou() && this.chegou()) {
			// Compara pelo tempo de corrida (SE ambos terminaram a corrida)
			ret = (int) (this.tempoDeCorrida - outro.tempoDeCorrida);
		}

		if (ret == 0) {
			// Compara pela distanciaPercorrida (SE a distanciaPercorrida for diferente um
			// do outro)
			ret = outro.distanciaPercorrida - this.distanciaPercorrida;
			if (ret == 0) {
				//	Comprara pela tamanho da corrida	(SE as distancias percorridas fossem a mesma)
				ret = outro.chegada - this.chegada;
				if(ret == 0) {
					// Compara pelo ID (SE nenhuma das condições anteriores forem satisfeitas)
					ret = (int) (this.getId() - outro.getId());
				}
			}
		}

		return ret;
	}

	@Override
	public String toString() {
		return "Corredor [id=" + this.getId() + ", chegada=" + chegada + ", distanciaPercorrida=" + distanciaPercorrida
				+ ", tempoDeCorrida=" + tempoDeCorrida + ", comSono=" + comSono + "]";
	}

	public int getChegada() {
		return chegada;
	}

	public void setChegada(int chegada) {
		this.chegada = chegada;
	}

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public long getTempoDeCorrida() {
		return tempoDeCorrida;
	}

	public void setTempoDeCorrida(long tempoDeCorrida) {
		this.tempoDeCorrida = tempoDeCorrida;
	}

	public boolean isComSono() {
		return comSono;
	}

	public void setComSono(boolean comSono) {
		this.comSono = comSono;
	}
}
