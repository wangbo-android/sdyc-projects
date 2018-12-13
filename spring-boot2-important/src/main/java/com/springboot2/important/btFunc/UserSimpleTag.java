package com.springboot2.important.btFunc;

import com.springboot2.important.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.core.GeneralVarTagBinding;
import java.util.ArrayList;
import java.util.List;

public class UserSimpleTag extends GeneralVarTagBinding{

    private static final Log log = LogFactory.getLog(UserSimpleTag.class);

    @Override
    public void render() {

        int type = Integer.parseInt((String)this.getAttributeValue("type"));

        log.info("##############" + type + "##########");

        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setName("wangbo");
        user1.setAge(30);
        user1.setId(1);

        User user2 = new User();
        user2.setName("zhangsan");
        user2.setAge(40);
        user2.setId(2);

        userList.add(user1);
        userList.add(user2);

        for(int i =0;i<userList.size();i++){

            this.binds(userList.get(i),i+1);
            this.doBodyRender();
        }
    }
}
