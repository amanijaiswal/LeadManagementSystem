CREATE DATABASE IF NOT EXISTS lead_management;

USE lead_management;

CREATE TABLE leads(

                      id BIGINT PRIMARY KEY AUTO_INCREMENT,

                      full_name VARCHAR(100) NOT NULL,

                      email VARCHAR(100) UNIQUE NOT NULL,

                      phone VARCHAR(20) NOT NULL,

                      company VARCHAR(100),

                      requirement TEXT,

                      submitted_time DATETIME,

                      email_sent BOOLEAN,

                      email_opened BOOLEAN,

                      link_clicked BOOLEAN

);

CREATE TABLE email_tracking(

                               id BIGINT PRIMARY KEY AUTO_INCREMENT,

                               lead_id BIGINT,

                               tracking_token VARCHAR(255) UNIQUE,

                               opened BOOLEAN,

                               clicked BOOLEAN,

                               opened_time DATETIME,

                               clicked_time DATETIME,

                               FOREIGN KEY (lead_id)
                                   REFERENCES leads(id)

);