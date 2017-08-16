package myJson;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private App appObj;
    private JSONObject obj;

    @Before
    public void Init() {
        appObj = new App();
    }
    
    @Test
    public void CostumeTest() 
    {

      obj = appObj.getJsonObj("test.json","Armen");
      System.out.println(obj.toString());
      JSONObject testObj = new JSONObject();
      ArrayList<String> list = new ArrayList<String>();
      list.add("India");
      list.add("Australia"); 
      testObj.put("Countries", list);
      testObj.put("Age", 999);
      testObj.put("Name", "Armen");
      assertEquals(testObj.toString(), obj.toString());
    }

    @After 
    public void CostumeTest2()
    {
        ArrayList<String> list = appObj.Print(obj, "Armen");
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("India");
        testList.add("Australia"); 
        System.out.println(testList.toString());
        System.out.println(list.toString());

        assertEquals(testList.toString(), list.toString());
    }

}
