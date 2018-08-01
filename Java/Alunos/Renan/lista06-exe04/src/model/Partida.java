package model;

public class Partida {

	protected Time timeA;
	protected int golsA;
	protected Time timeB;
	protected int golsB;

	public boolean isEmpate() {
		return golsA == golsB;
	}

	public Time getVencedor() {
		if (golsA > golsB) {
			return timeA;
		} else if (golsB > golsA) {
			return timeB;
		} else {
			return null;
		}
	}

	public int getGolsPro(Time time) {
		if (time.equals(timeA)) {
			return golsA;
		} else {
			return golsB;
		}
	}

	public int getGolsSofridos(Time time) {
		if (time.equals(timeA)) {
			return golsB;
		} else {
			return golsA;
		}
	}

	public boolean isVencedor(Time time) {
		Time vencedor = getVencedor();

		return vencedor != null && vencedor.equals(time);
	}

	public Time getPerdedor() {
		if (golsA > golsB) {
			return timeB;
		} else if (golsB > golsA) {
			return timeA;
		} else {
			return null;
		}
	}

	public Time getTimeA() {
		return timeA;
	}

	public void setTimeA(Time timeA) {
		this.timeA = timeA;
	}

	public int getGolsA() {
		return golsA;
	}

	public void setGolsA(int golsA) {
		this.golsA = golsA;
	}

	public Time getTimeB() {
		return timeB;
	}

	public void setTimeB(Time timeB) {
		this.timeB = timeB;
	}

	public int getGolsB() {
		return golsB;
	}

	public void setGolsB(int golsB) {
		this.golsB = golsB;
	}

	@Override
	public String toString() {
		return "Partida [timeA=" + timeA + ", golsA=" + golsA + ", timeB=" + timeB + ", golsB=" + golsB + "]";
	}

}
