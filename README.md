# Creating-Two-tables-using-Hibernate


Two tables has been created 1. user(homecontroller,userlist,userform,userdao,userdaoimpl) 2. student(rest)
----------------------------------------------------------------------------------------------------------------------
PROCEDURE
____________

  NEW USER : - SAVE ACTION 
  
  userlist is the first step. once we press new goes to controller and creates new userform
when submit is click action is taken to save in controller and new User() is calle(in user model)
and creates a new user values and newuser function has ModelView which returns whole model not as seprate variables
like model(https://stackoverflow.com/questions/18486660/what-are-the-differences-between-model-modelmap-and-modelandview) 
and displays in userList


EDIT : - SAVE ACTION


when edit is pressed it goes to home controller edit and it gets the id and id is passed to user DAO and now get() is called in
userDAO and get() is implemented in userDAOImpl it takes the id which should be edited and 
	if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
    
    listuser will have only one row which has been taken and brought. so get(0)  [only one column] and gives to homecontroller and again forwarded 
    to userform and now it is been save... save action is taken to save in controller.......
    
    DELETE : delete is same as EDIT

<<<-----H2 DATABASE has been used----------->>>>
 so run as mvn spring-boot:run 


=======> 26-02-2018
 
 
 

