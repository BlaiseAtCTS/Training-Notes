# Web Dev Notes
Client: The function which executes operations when a front end element is interacted with.
Server: Works between Client and Backend. Many clients interact with server to update db, get data etc.

## Git:
### Code:
git branch -> shows current branch name
git checkout -b "feature-javascript" -> create new branch with -b
git checkout "feature-javascript" -> switch to existing branch
git merge master -> do while currently in feature branches
git log -> history of commits
### Merging:
1. Switch to feature-javascript / feature-css branch.
2. Add javascript features in feature-javascript branch.
3. Add css features in feature-css branch.
4. Now Main branch is updated with new features (Main branch is forward of feature branches).
5. Can’t merge feature branches to main branch when main branch is forward (Causes merge conflicts).
6. So merge new version of master to feature branch and fix any conflicts.
7. If no conflicts, merge feature branch to master.

## Javascript:
### Variables:
Container of information.
Eg. let num = 5 -> value = 5, type = number. 
let num = "5" -> value = 5, type = string
### Types:
Weak type: Eg. let num = 5; num = "five" -> can change not just value but also type (javascript)
Strong type: Eg. let num = 5; num = 10 -> can change only value, not type (typescript)
### Programming Types:
Dynamic: Runtime Errors (javascript)
Static: Compile Time Errors (typescript)

TypeScript is Superset of JavaScript. Typescript code is Transpiled to Javascript.

## JQuery:
A library: A collection of code added to project to implement features quick, instead of writing the code ourselves. Library lets us use code whenever we need, unlike framework which has a lifecycle.

## Angular: (uses typescript by default)
ng create example -> create angular project
ng serve -> start application
app.component.html -> html file for user
*React is a library with framework like features. (uses javascript by default)

## Bootstrap:
Framework for frontend. Other frameworks are getskeleton, angular material, tailwind css.

## Http Protocol:
A standard protocol between client and server. Client initiates the request, so its a request - response model.

## API: 
When an application wants to communicate with other applications, library or frameworks.
Client -> API -> Server (or) Client <-> Backend
Rest API is Resource based, while some other APIs are Action based.

## Web Socket:
Since APIs are Client initiated, if we need bi-directional communication, we use Web Socket API. The browser and server can both broadcast messages that the other listens for (Client 1 browser broadcasts message to server, server broadcasts message to Client 2).

## Authentication (AuthN):
Who the user is?

## Authorization (AuthZ):
What the user can do?

## OAuth:
Open Authorization is used along with OIDC (Open ID Connect)(used for authentication). Gives 3rd party applications limited access to users data. Eg. App1 uses OAuth with Google. Google authenticates user. App1 asks Google for email of user which Google has, it then asks for permission to share email with App1 (Authorization).

## Backend Framework:
Backend framework give developers the tools to create applications that are capable of receiving requests over the internet, turning those applications into servers.

### Microframeworks: 
Has a lifecycle that a developer can build on top of, but leaves some decisions and implementations to the developer.

### Modules and Packages:
Similar to libraries, we can add small packages to do some work in our microframework project.

### Webframeworks:
More modern web experiences. Eg. .Net, Spring.

