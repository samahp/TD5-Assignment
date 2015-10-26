#Tech Day Assignment - Writing a Jersey Webservice.

####Setup
1. Go to https://github.com/jking31cs/jersey-api-example and fork that repo.
2. Clone your forked repo onto your computer.
3. Check out the branch "User-Setup".
4. To ensure everything is working, run the following command:``` ./gradlew appengineRun ```
Then navigate to ```http://localhost:8080```.
You should see  a web page, meaning that the server is up and running.

####Assignment
The assignment is to create a web service for the User object, already included in this branch with DB support.
The following table describes what urls you're creating and what the inputs/outputs should be.

| Http Method | Url           | Input       | Response    | Description                    |
|-------------|---------------|-------------|-------------|--------------------------------|
| GET         | api/users     |             | List<User>  | Gets all users in the system.  |
| GET         | api/users/{id}|             | User        | Gets user with specific id.    |
| POST        | api/users     | User        | User        | Creates a new user.            |
| PUT         | api/users/{id}| User        | User        | Updates a user in the system.  |
| DELETE      | api/users/{id}|             | User        | Deletes a user from the system.|

Note that every url returns a response of either a List<User> or User.
The following JSON Format should be expected.

```
{
    "id": 1234, //Note this isn't required for creating a user.
    "name": "John Doe",
    "email": "jdoe3@gmail.biz"
}
```

In the java side of things, there is a Class called UserStore that you can use to save/retrieve your data.  
Here is its api.

| Return Type | Method Name | Description                                                                               |
|-------------|-------------|-------------------------------------------------------------------------------------------|
| List<User>  | getAll()    | Returns all users in the system.                                                          |
| User        | save(User)  | Saves the user in the store and returns the updated user. (including new id if new user.) |
| User        | get(Long)   | Gets the user with the id of the passed in parameter.                                     |
| User        | delete(User)| Deletes the passed in user from the datastore and returns it.                             |

You're responsible for creating the web service with the correct injected dependencies.
Also, you should update the constructor of the User class in the objects package to have the correct Jackson Annotations.
When finished, please post a link to your repo and a commit hash to checkout.
The graders will checkout out that repo, run a local instance, and run tests via Postman to confirm everything works.

If there are any questions regarding the assignment, please post to Piazza, and we'll try to help to the best of our ability.
The assignment shouldn't take more than 2 hours at most, since everything is set up except the web service.
