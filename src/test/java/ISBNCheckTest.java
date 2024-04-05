import org.junit.Test;

import static org.junit.Assert.*;

public class ISBNCheckTest {
    //Valid ISBN  140177396
    @Test
    public void checkValidShortISBN(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
       boolean result = isbnCheck.checkISBN("0140449116");
       //Then
        assertTrue("First ISBN",result);

        result = isbnCheck.checkISBN("0140177396");
        assertTrue("Second ISBN",result);


    }
   @Test
    public void checkInvalidShotISBN(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
        boolean result = isbnCheck.checkISBN("0140449110");
        //Then
        assertFalse(result);

    }
    @Test(expected = NumberFormatException.class)
    public void lessThanOrGreaterThan10Invalid(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //when
        isbnCheck.checkISBN("123456789");
        //then throw numbeFormatException

    }
    @Test(expected = NumberFormatException.class)
    public void alphabeticalCharsInvalid(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
        isbnCheck.checkISBN("helloWorld");
    }
    @Test
    public void checkValidISBNEndingWithX(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
        boolean result = isbnCheck.checkISBN("140274577X");
        //Then
        assertTrue(result);

    }
    //valid 13 digit 9780345538376
    @Test
    public void checkValidLongISBN(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
        boolean result = isbnCheck.checkISBN("9780345538376");
        //Then
        assertTrue("13digit ISBN",result);
    }
    @Test
    public void checkInvalidLongISBN(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
        boolean result = isbnCheck.checkISBN("9780345538370");
        //Then
        assertFalse(result);

    }
    @Test(expected = NumberFormatException.class)
    public void checkSpaceInvalidLongISBN(){
        //Given
        ISBNCheck isbnCheck = new ISBNCheck();
        //When
        boolean result = isbnCheck.checkISBN("9780 45538370");
        //Then
        assertFalse(result);

    }
}
