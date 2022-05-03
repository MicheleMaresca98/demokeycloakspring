demokeycloakspring
===================================================

The `demokeycloakspring` demonstrates how to write a SpringBoot Web application where both authentication and
authorization aspects are managed by <span>Keycloak</span>.

This application tries to focus on the authorization features provided by <span>Keycloak</span> Authorization Services, where resources are
protected by a set of permissions and policies defined in Keycloak itself and access to these resources are enforced by a policy enforcer
that intercepts every single request to the application.

In this application, there are two paths protected by specific permissions in <span>Keycloak</span>:

* **/protected**, where access to this page is based on the evaluation of permissions associated with a resource **Protected Resource** in <span>Keycloak</span>. Basically,
any user with a role *user* is allowed to access this page.

* **/protected/premium**, where access to this page is based on the evaluation of permissions associated with a resource **Premium Resource** in <span>Keycloak</span>. Basically,
only users with a role *user-premium* is allowed to access this page.

You can use two distinct users to access this application:
|Username|Password|Roles|
|---|---|---|
|alice|alice|user|
|jdoe|jdoe|user, user-premium|

Configuration in <span>Keycloak</span>
-----------------------
Prior to running the demokeycloakspring you need to create a `realm` in <span>Keycloak</span>.

The following steps show how to create the realm required for this demo:
* Open the <span>Keycloak</span> admin console
* In the top left corner dropdown menu that is titled `Master`, click `Add Realm`. If you are logged in to the master realm this dropdown menu lists all the realms created.
* For this demo we are not going to manually create the realm, but import all configuration from a JSON file. Click on `Select File` and import the [realm-export.json](./realm-export.json).
* Click `Create`

The steps above will result on a new `demokeycloakspring` realm.

Build and Run the Quickstart
-------------------------------

Make sure your <span>Keycloak</span> server is running on <http://localhost:8180/>. For that, you can start the server using the command below:

   ````
   cd {KEYCLOAK_HOME}/bin
   ./standalone.sh -Djboss.socket.binding.port-offset=100
   
   ````

If your server is up and running, perform the following steps to start the application:

1. Open a terminal and navigate to the root directory of this quickstart.

2. The following shows the command to deploy the demo:

   ````
   ./mvnw spring-boot:run
   ````

Access the Demo
---------------------

You can access the application with the following URL: <http://localhost:8081/>.
