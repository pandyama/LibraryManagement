package Library.Objects;

public class Person {
    protected int id = -1;
    protected String fName;
    protected String lName;
    protected String loginId;
    protected String password;
    protected String phone;
    protected String address;
    protected int type;

    public Person(String firstname, String lastname, String pw, String ph, String addr, int ptype){
        if(id == -1){
            id = 1;
        }
        else{
            id++;
        }
        fName = firstname;
        lName = lastname;
        loginId = firstname.charAt(0)+lastname;
        password = pw;
        phone = ph;
        address = addr;
        type = ptype;
    }

    public void setFirstName(String fn){
        fName = fn;
    }

    public void setLastName(String ln){
        lName = ln;
    }

    public void setLogin(String login){
        loginId = login;
    }

    public void setPassword(String pw){
        password = pw;
    }

    public void setPhone(String ph){
        phone = ph;
    }

    public void setAddress(String addr){
        address = addr;
    }

    public void setType(int ptype){ type = ptype; }


    public String getFirstName(){
        return fName;
    }

    public String getLastName(){
        return lName;
    }

    public String getLogin(){
        return loginId;
    }

    public String getPassword(){
        return password;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public int getType(){ return type; }

}
