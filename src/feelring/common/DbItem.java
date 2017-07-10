package feelring.common;

public class DbItem {
	 	private Integer nId     	= 0;
		private String szType		= "";
	 	private String szName		= "";
	 	private String szObject		= "";
	 	private String szDataName	= "";
	 	private String szDataValue	= "";
	 	private String szRegDate	= "";
		
	 	
	 	public DbItem(){
	 		this.nId     	= 0;
	 		this.szType		= "";
	 		this.szName		= "";
	 		this.szObject	= "";
	 		this.szDataName	= "";
	 		this.szDataValue= "";
	 		this.szRegDate	= "";
	 	}
	 	
	 	public void a(){}
	 	
	 	public Integer getNId() {
			return nId;
		}
		public void setNId(Integer nId) {
			this.nId = nId;
		}
		
		public String getSzType() {
			return szType;
		}
		public void setSzType(String szType) {
			this.szType = szType;
		}
		public String getSzName() {
			return szName;
		}
		public void setSzName(String szName) {
			this.szName = szName;
		}
		public String getSzObject() {
			return szObject;
		}
		public void setSzObject(String szObject) {
			this.szObject = szObject;
		}
		public String getSzDataName() {
			return szDataName;
		}
		public void setSzDataName(String szDataName) {
			this.szDataName = szDataName;
		}
		public String getSzDataValue() {
			return szDataValue;
		}
		public void setSzDataValue(String szDataValue) {
			this.szDataValue = szDataValue;
		}
		public String getSzRegDate() {
			return szRegDate;
		}
		public void setSzRegDate(String szRegDate) {
			this.szRegDate = szRegDate;
		}




}
