public class Schiff {

	public int laenge = 0;
	public int positionX = 0;
	public int positionY = 0;
	public char orientierung = 'v';
	public char[][] koordinaten = null;

	public Schiff(int laenge, int positionX, int positionY, char orientierung) {

		this.laenge = laenge;
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientierung = orientierung;

		this.koordinaten = new char[11][11];

		if (orientierung == 'h') {
			for (int s = 0; s < this.laenge; s++) {
				this.koordinaten[this.positionY][this.positionX + s] = '#';
			}
		} else {
			for (int z = 0; z < this.laenge; z++) {
				this.koordinaten[this.positionY + z][this.positionX] = '#';

			}
		}

	}

}