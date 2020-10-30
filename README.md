# SpringBoot-RestAPI

- A Spring Boot project using H2 database

- Below insert queries can be used:

INSERT INTO application (application_id, app_name, description, owner) VALUES (1, 'Trackzilla','A bug tracking application', 'Kesha Williams');
INSERT INTO application (application_id, app_name, description, owner) VALUES (2, 'Expenses','An application used to submit expenses', 'Jane Doe');
INSERT INTO application (application_id, app_name, description, owner) VALUES (3, 'Bookings','An application used to book tickets', 'John Doe');
INSERT INTO application (application_id, app_name, description, owner) VALUES (4, 'Invoice Search','An application used to search invoices ', 'Mary Richards');
INSERT INTO application (application_id, app_name, description, owner) VALUES (5, 'Audits','An application used for auditing purposes.', 'Tiffany Stewart');

INSERT INTO release (id, description, release_date) VALUES (1,'Q1 Release Containing High Priority Bugs', '2030-02-14');
INSERT INTO release (id, description, release_date) VALUES (2,'Q2 Release Containing High Priority Enhancements', '2030-05-27');
INSERT INTO release (id, description, release_date) VALUES (3,'Q3 Release Containing Bugs', '2030-09-14');
INSERT INTO release (id, description, release_date) VALUES (4,'Q4 Release Containing Enhancements', '2030-12-10');

INSERT INTO developer_applications (developer_Id, application_id) VALUES (1,3);
INSERT INTO developer_applications (developer_Id, application_id) VALUES (2,1);
INSERT INTO developer_applications (developer_Id, application_id) VALUES (2,4);
INSERT INTO developer_applications (developer_Id, application_id) VALUES (3,1);
INSERT INTO developer_applications (developer_Id, application_id) VALUES (4,1);

INSERT INTO developers (developer_Id, developer_Name) VALUES (1,'Garima Tuli');
INSERT INTO developers (developer_Id, developer_Name) VALUES (2,'Ginni');
INSERT INTO developers (developer_Id, developer_Name) VALUES (3,'Ankur');
INSERT INTO developers (developer_Id, developer_Name) VALUES (4,'Abhinav');
