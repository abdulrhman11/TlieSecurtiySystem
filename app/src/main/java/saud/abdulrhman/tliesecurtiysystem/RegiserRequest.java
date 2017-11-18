package saud.abdulrhman.tliesecurtiysystem;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PCD on 10/31/2017.
 */

public class RegiserRequest extends StringRequest {

    private static final String REGITSER_REQUEST_URL = "http://tilesecurity.xyz/loginApp/Register.php";
    private Map<String,String>params;

    public RegiserRequest(String name, String username,String email, String password , Response.Listener<String> listener){
        super(Method.POST,REGITSER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
        params.put("email",email);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
