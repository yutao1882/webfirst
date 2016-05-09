package M.M;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JmeterDes {

	public String getDesString(String message, String key) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String result = "";

		try {
			engine.eval(new FileReader("D:\\eclipse\\tripledes.js"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ScriptException e1) {
			e1.printStackTrace();
		}
		Invocable inv = (Invocable) engine;
		try {
			result = (String) inv.invokeFunction("encryptByDES", message, key);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		String s = new JmeterDes().getDesString("rrr", "bbb");
		System.out.println(s);

	}

}
