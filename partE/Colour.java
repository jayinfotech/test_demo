

public enum Colour {

	BLACK, WHITE;

	Colour nextColor() {
		return this.equals(BLACK) ? WHITE : BLACK;
	}
}
