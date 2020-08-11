package chapter02;

public class Case02MethodnadArray {

	public static void main(String[] args) {
		// Reference type array:
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(1,2);
		cells[1] = new Cell(2,3);
		cells[2] = new Cell(3,4);
		cells[3] = new Cell(4,5);
		
		Cell[] cells1 = new Cell[] {new Cell(1,2), new Cell(2,3), new Cell(3,4), new Cell(4,5)};
		for (int i = 0; i < cells1.length; i++) {
			System.out.println(cells1[i].toString());
		}
	}
	
	// Method overload:
	// Method sign: method name and argument list.
	public boolean pay(double money) {return true;}
	public boolean pay(String cardNo, String pwd) {return false;}
}


// Constructure:
class Cell {
	int raw;
	int col;
	
	// Initialize member variable through constructure:
	public Cell(int raw, int col) {
		super();
		this.raw = raw;
		this.col = col;
	}
	
	// Key word 'this':
	public void drop() {
		this.raw++;
	}
	
	// Default constructure:
	Cell(){}

	@Override
	public String toString() {
		return "Cell [raw=" + raw + ", col=" + col + "]";
	};
}
