public class ISBNCheck {

    public static final int LONG_ISBN = 13;
    public static final int SHORT_ISBN = 10;
    public static final int LONG_ISBN_CHECK_DIGIT_MULTIPLIER = 10;
    public static final int SHORT_ISBN_CHECK_DIGIT_MULTIPLIER = 11;

    public boolean checkISBN(String  isbn) {
        if(isbn.length() == LONG_ISBN){
            return isValid13DigitISBN(isbn);
        }else if(isbn.length() == SHORT_ISBN){
            return isValid10DigitISBN(isbn);
        }
        throw new NumberFormatException("ISBN should be 10 digits only");
    }

    private static boolean isValid10DigitISBN(String isbn) {
        int total =0;
        for(int i=0; i<SHORT_ISBN; i++){
            if(!Character.isDigit(isbn.charAt(i))){
                if(i == 9 && isbn.charAt(i) == 'X'){
                    total += 10;
                }else{
                    throw new NumberFormatException("ISBN should be numeric");
                }
            }else{
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN-i);
            }
        }
       return total % SHORT_ISBN_CHECK_DIGIT_MULTIPLIER == 0;

    }

    private static boolean isValid13DigitISBN(String isbn) {
        int total = 0;
        for(int i= 0; i<LONG_ISBN; i++){
            if( Character.isWhitespace(isbn.charAt(i))){
                throw new NumberFormatException("ISBN should be without space");
            }
            if(i%2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            }else{
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return total % LONG_ISBN_CHECK_DIGIT_MULTIPLIER == 0;

    }
}
