/**
	 * I declare that this code was written by me.
	 * I will not copy or allow others to copy my code.
	 * I understand that copying code is considered as plagiarism.
	 *
	 * vino, 10 Aug 2023 11:03:25 pm
	 */

	/**
	 * @author vino
	 *
	 */
public class VendorMenu {
	private String menuCode;
	private String menuName;
		
	public VendorMenu(String menuCode, String menuName) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		}
	
	public String toString() {
		String itemInfo =  String.format("%-30s %-10s\n", menuCode, menuName);
		return itemInfo;
		}

		public String getMenuCode() {
			return menuCode;
		}
		
		public String getMenuName() {
			return menuName;
		}
		
	}


