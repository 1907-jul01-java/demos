# Continuous Integration

>"Continuous Integration is a software development practice where members of a team integrate their work frequently, usually each person integrates at least daily - leading to multiple integrations per day. Each integration is verified by an automated build (including test) to detect integration errors as quickly as possible. Many teams find that this approach leads to significantly reduced integration problems and allows a team to develop cohesive software more rapidly." 
<div style="text-align: right">~Martin Fowler</div>

DevOps culture aims to minimize the barriers between developers and operations as a whole, but it also streamlines the development process itself through Continuous Integration (CI). 

When working with several developers on a single code repository, safely integrating many changes from each developer is a challenge. Too few integrations and the code base may introduce bugs or become broken without any clear insight into when and how it happened. Each developer should not only be responsible for maintaining up-to-date code on their development environments, but also be responsible for regularly committing new code that passes local unit tests.

## Automated builds
As developers integrate new code, an automated build on a server separate from each of their development environments should trigger. After the build is pulled from the repository, compiled, and tested automatically, the developers should be notified of any and all issues or errors introduced by recent commits. This ensures any problems introduced into the repository are quickly highlighted before becoming buried by the next round of commits.

### Scripts
On a build server, the automated process may be as simple as a scheduled script which pulls the latest code from the repository, builds a new artifact from the changes, and logs and reports on the status of any compiling errors or test failures. The following is an example for a Linux server. This can be added as a `cron` job to periodically trigger your build.

#### `build.sh`
```bash
#!/bin/bash
git pull https://your-repository.git
cd your-repository/
mvn clean package
```

Then run `crontab -e` and add an interval (minute hour day-of-month month day-of-week) along with the command to run:
#### crontab
```bash
# Run every minute
* * * * * /bin/sh /path/to/build.sh
```

### CI/CD Tools
Advanced tools like Jenkins, Circle-CI, Travis-CI, and many more simplify the automation process. Whether hosted on your own build server or as a cloud service, they can coordinate SCM, build, deployment, and messaging tools through a user-friendly web interface and have access to a large community of plugins or excellent integration with repository services like GitHub.

# Continuous Delivery
>The essence of my philosophy to software delivery is to build software so that it is always in a state where it could be put into production. We call this Continuous Delivery because we are continuously running a deployment pipeline that tests if this software is in a state to be delivered.
<div style="text-align: right">~Martin Fowler</div>

Just as a team of developers use continuous, automated builds to integrate new changes to their code base rapidly, efficiently, and safely, an operations team benefits from automating a rapid delivery process of that build to the various teams and servers in preparation for deployment.

## Pipelines
The process of moving the build (or rebuilding from source) beyond the initial Continuous Integration build is called Continuous Delivery (CD), and the solution that implements this process is known as the deployment (or build) pipeline.

The first CI bulid, the build triggered by a commit or series of commits by developers, should be done quickly to satisfy CI requirements: quick unit tests and error-free compilations are enough. But afterwards the code base should be made available to other teams to run more extensive testing and performance monitoring.

An example two stage deployment pipeline would have the first stage do the CI compilation and unit testing while the second stage builds on a separate testing server to handle integration and end-to-end behavior testing. Further stages can be added at will, triggered at their own intervals.

Just like with CI, simple scripts can automate the process of building, testing, or deploying to staging servers. Tools such as Jenkins also simplify the process of building pipelines and can coordinate multiple servers with ease.
