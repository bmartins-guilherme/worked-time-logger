# Worked Time Logger 


## EPIC 1 - User Service

### USER STORY 01 - Insert user
**As** a new user \
**I want** to register myself \
**So that** I can log my worked time

#### Acceptance Criteria
+ Successful registrations return HTTP 201
+ All fields are mandatory
+ Invalid values return HTTP 400

### Business Rules
+ User must provide `name`, `email`, `username` and `password` to be registered
+ Each user must have a unique `username` 


### USER STORY 02 - List users
**As** a user \
**I want** to list users \
**So that** I know registered users


#### Acceptance Criteria
+ Successful requests return HTTP 200
+ Response contains `id`, `name` and `username`
+ Unauthorized requests return HTTP 401


### USER STORY 03 - Find user by ID
**As** a user \
**I want** to find a user by ID \
**So that** I retrieve the user details

#### Acceptance Criteria
+ Requests for found users return HTTP 200
+ Response must contain `id`, `name`, `email` and `username`
+ Requests for a non-existing user return HTTP 404
+ Unauthorized requests return HTTP 401


### USER STORY 04 - Find user by Username
**As** a user \
**I want** to find a user by username \
**So that** I don't need to search for a user's ID

#### Acceptance Criteria
+ Requests for found users return HTTP 200
+ Response must contain `id`, `name`, `email` and `username`
+ Requests for a non-existing user return HTTP 404
+ Unauthorized requests return HTTP 401


### USER STORY 05 - Update user
**As** a user \
**I want** to update my record \
**So that** my data are up to date

#### Acceptance Criteria
+ Requests for successful updates return HTTP 200
+ Response must return all data: `id`, `name`, `email` and `username`
+ Requests for a non-existing user return HTTP 404
+ Unauthorized requests return HTTP 401


##  EPIC 2 - Authentication Service

### USER STORY 06 - User authentication
**As** a user \
**I want** authentication \
**So that** I can use a validation token in my requests

#### Acceptance Criteria
+ Successful authentication requests return HTTP 201
+ Response must return a token
+ Unsuccessful requests return HTTP 401


### USER STORY 07 - Token validation
**As** a user \
**I want** to validate my token \
**So that** my requests are secure

#### Acceptance Criteria
+ Successful token validation requests return HTTP 200
+ Response must return `id` and `username`
+ Invalid token requests return HTTP 401



##  EPIC 3 - Task Management

### USER STORY 08 - Create task
**As** a user \
**I want** to store my task \
**So that** I can log my worked time 

#### Acceptance Criteria
+ Successfully stored tasks must return all fields
+ Successful requests return HTTP 201
+ Unauthorized requests return HTTP 401

#### Business Rules
+ User must provide `name` to save into the database
+ Every task must be saved with status `TO_DO`
+ Successful response must return `id`, `name`, `status` and `created_by`
+ The field `created_by` must inform `id` and `username`


### USER STORY 09 - List tasks
**As** a user \
**I want** to list tasks \
**So that** I can see stored tasks

#### Acceptance Criteria
+ Response must be pageable
+ The fields `id`, `name` and `status` must be returned
+ Successful responses return HTTP 200
+ Unauthorized requests return HTTP 401

### Business Rules
+ User can filter tasks by `name` and `status`
+ User can filter tasks that contain a sequence of words
+ The `name` filter must be case-insensitive
+ Response must be sorted by id
+ Response must return 5 tasks per page if the user does not define it


### USER STORY 10 - Find tasks
**As** a user \
**I want** to find a task by ID \
**So that** I have only one task

#### Acceptance Criteria
+ Response must return task data and HTTP 200
+ Response body must contain `id`, `name`, `status` and `created_by`
+ Response must return HTTP 404 with no content if task is not found
+ Response must be pageable
+ The fields `id`, `name` and `status` must be returned
+ Successful responses return HTTP 200
+ Unauthorized requests return HTTP 401

### Business Rules
+ The field `created_by` must inform `id` and `username`

### USER STORY 11 - Update tasks
**As** a user \
**I want** to modify task data \
**So that** the task is up to date

#### Acceptance Criteria
+ Successful updates must return HTTP 200 and all task fields
+ Response must be empty and HTTP 404 if task is not found
+ Unauthorized requests return HTTP 401


### USER STORY 12 - Delete task
**As** a user \
**I want** to delete a task \
**So that** I don't list tasks that were created by mistake

#### Acceptance Criteria
+ Successful deletion must return HTTP 204
+ If the task was not found, response must return HTTP 404
+ Unauthorized requests return HTTP 401



##  EPIC 4 - Worked Time Management

### USER STORY 13 - Insert worked time
**As** a user \
**I want** to log my worked time \
**So that** I report my work to stakeholders

#### Acceptance Criteria
+ User must provide `task`, `start` and `end`
+ Response must return HTTP 201 for successful requests
+ Response body must contain `id`, `user`, `task`, `start` and `end` 
+ Response must return HTTP 400 if an inconsistency is found.
+ Unauthorized requests return HTTP 401

#### Business Rules
+ The fields `start` and `end` must be validated
+ The field `user` must inform `id` and `username`
+ The field `task` must inform `id` and `name`
+ Worked time must be included only when the task is `IN_PROGRESS`


### USER STORY 14 - List worked time
**As** a user \
**I want** to list logged time \
**So that** I can see worked tasks

#### Acceptance Criteria
+ Response must be pageable
+ The fields `worked_time`, `user`, `task`, `start` and `end` and `duration` must be returned
+ Successful responses return HTTP 200
+ Unauthorized requests return HTTP 401


### Business Rules
+ Return must be pageable
+ Page must be ordered by newest
+ Page size must be equal to 5 if the user does not define it
+ User can filter by date and time using parameters `from` and `until`
+ The field `user` must inform `id` and `username`
+ The field `task` must inform `id` and `name`


### USER STORY 15 - Update worked time
**As** a user \
**I want** to modify my logged time \
**So that** my logged time is corrected

#### Acceptance Criteria
+ Successful update request must return HTTP 200
+ Updated logged time must return `id`, `user`, `task`, `start` and `end`
+ Unsuccessful update request must return HTTP 400
+ Unauthorized requests return HTTP 401

### Business Rules
+ User cannot modify logged time of other users
+ The fields `start` and `end` must be validated
+ The field `user` must inform `id` and `username`
+ The field `task` must inform `id` and `name`


### USER STORY 16 - Delete worked time
**As** a user \
**I want** to delete incorrect logged times \
**So that** I can trust my logs

#### Acceptance Criteria
+ Successful deletion requests must return HTTP 204
+ Unsuccessful requests for non-existing times must return HTTP 404
+ Unauthorized requests must return HTTP 401

### Business Rules
+ User cannot delete logged times of others
+ User provides only worked time `id` to delete it

### USER STORY 17 - Worked time by Username
**As** a user \
**I want** to list worked time by username \
**So that** I can extract reports

#### Acceptance Criteria
+ Unauthorized requests return HTTP 401
+ Successful requests return HTTP 200
+ Successful requests return fields as in this example:
```json
{
    "user": {
        "id": 0,
        "username": "username",
        "userDetail": {
            "name": "Fullname",
            "email": "username@provider.com"
        }
    },
    "workedTimes": [
        {
            "id": 0,
            "task": {
                "id": 0,
                "name": "task name"
            },
            "start": "2026-06-20 13:15",
            "end": "2026-06-20 17:45",
            "duration": 4.5
        },
        ...
    ]
},

```

### Business Rules
+ User must provide a user `id`
+ Return must be pageable
+ Page must be ordered by newest
+ Page size must be equal to 5 if the user does not define it
+ User can filter by date and time using parameters `from` and `until`