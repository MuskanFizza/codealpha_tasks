package task4;

	class Customer {
	    String name;
	    int id;
	    long phoneNo;
	    String cnic;
	    double bill;
	    
	    public Customer(String name, int id, long pno, double bill) {
	    	this.name=name;
	    	this.id=id;
	    	this.phoneNo=pno;
	    	this.bill=bill;
	    }
	    public Customer() {
	    	this.name=null;
	    	this.id=0;
	    	this.phoneNo=0;
	    	this.bill=0.0;
	    }
}
