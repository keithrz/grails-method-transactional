grails-method-transactional
===========================

Test project created to isolate issues with the Transactional annotation using the Hibernate4 Grails Plugin.

http://jira.grails.org/browse/GPHIB-15

If an instance of a JPA domain is loaded into the current Hibernate session via a service method with Transactional(readOnly = true), updates made to the instance are never persisted, even if the instance is later saved in a service method with Transactional(readOnly = false)

This is only true for JPA domains in Grails 2.3.x. Updates to Grails domains in this scenario do get persisted.
This is true for both the Hibernate 3 & Hibernate 4 Grails plugins.

In this test project, you can test the various scenarios by navigating to:
http://localhost:8080/gmt/my/method
http://localhost:8080/gmt/my/type

For the "my/method" form, the JPA domain is only persisted if the checkbox "Use write method before calling method-scoped service" is checked.
For the "my/type" form, the JPA domain is only persisted if the checkbox "Use readOnly type-scoped service before calling writable type-scoped service" is unchecked.

The propagation type was never specified in any annotations; ie. the default was always used.

It did not seem to matter if the Spring Transactional annotation or the Grails Transactional annotation was used.

Due to other issues with Integration tests, it is difficult isolating this to an Integration Spock Spec. The easiest way to test this is to run-app and go to the URLs listed above.
