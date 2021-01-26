/**
 * 
 * @author Thomas Weisel
 *
 */
public class Flotte {

	public int limit3 = 1;
	public int limit4 = 1;
	public int limit5 = 1;

	public int anzahl = 0;

	public int limit = limit3 + limit4 + limit5;

	public String spielerName = "default";

	public Schiff[] schiffe = null;

	public Flotte(String spielerName) {
		this.spielerName = spielerName;
		this.schiffe = new Schiff[limit];
	}

	public void neuesSchiff(Schiff neuesSchiff) {
		if (this.anzahl < this.schiffe.length) {
			this.schiffe[this.anzahl] = neuesSchiff;
			this.anzahl++;

//			switch (neuesSchiff.laenge) {
//			case 3:
//				this.limit3--;
//			case 4:
//				this.limit4--;
//			case 5:
//				this.limit5--;
//			default:
//				System.out.println("Oh oh!");
//			}
		}
	}
}
