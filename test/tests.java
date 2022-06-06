import fc.functions.Function;
import org.junit.Test;
import static org.junit.Assert.*;
public class tests {
    @Test
    public void KosztJednaosobaTest(){
        Function function = new Function();
        assertEquals(17.50,function.KosztJednaosoba(2,5,100,7),1);

    }

    @Test
    public void KosztPaliwaWynikTest() {
        Function function = new Function();
        assertEquals(120.12,function.KosztPaliwaWynik(11,150,7.28),1);
    }
}
