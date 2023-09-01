public enum User {
	OWNER, COMPANY;

    public static boolean isAuthorized(BankAccountProxy bankAccountProxy) {
        return false;
    } 
}
