[![Live Demo](https://img.shields.io/badge/demo-live-brightgreen)](https://jobpostingwebapp.onrender.com/)

This webapp is a job portal where companies can post jobs and job seekers can applies to job postings.
Stack: Java for backend
Framework: Spring Boot
Dependencies: Spring Web, Lombok, Jakarta Standard Tag Library API and Library, Jasper to convert JSP to servlet

Some points worth noting.

- **jobPost** is a Data Transfer Object;
- @Autowired on service and repo layers:

We need the @Autowired annotation on the jobService field in JobController, 
because JobService is a dependency that JobController doesn't construct itself.
Spring's IoC container creates the JobService bean once, when the application starts, 
and @Autowired tells Spring to inject that existing instance into JobController's field at that point.

The same applies to the repo field in JobService: 
it's a dependency that Spring injects with @Autowired once, 
when it builds the JobService bean at startup — not each time addJob or getAllJobs is called. 
Once wired, both jobService and repo are just object references sitting on their respective beans, 
reused for every request.
