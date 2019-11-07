import java.util.HashMap;

public class UserHashMapSingleton {

    private static UserHashMapSingleton single_instance = null;

    private HashMap<Integer, User> userMap;

    private UserHashMapSingleton(){
        userMap = new HashMap<Integer, User>();
    }

    public static UserHashMapSingleton getInstance() {
        if (single_instance == null) { single_instance = new UserHashMapSingleton(); }
        return single_instance;
    }

    public User getUser(int id){
        return userMap.getOrDefault(id, null);
        // the above line of code was IDE-Auto-Generated to replace:
        //else if(userMap.containsKey(id)) { return userMap.get(id); }
        //else { return null; }
        // basically, what it does is it gets the User associated with the given id, or it returns null.
    }

    public int addUser(User user){
        int id = userMap.size() + 1;        // since we can't delete users, just use map size for user id's
        userMap.put(id, user);
        return id;
    }

}
