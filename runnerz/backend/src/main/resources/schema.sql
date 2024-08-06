CREATE TABLE Run (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    startPoint VARCHAR(255),
    endPoint VARCHAR(255),
    startTime TIMESTAMP,
    endTime TIMESTAMP,
    CONSTRAINT chk_endTime_after_startTime
    CHECK (endTime IS NULL OR endTime > startTime)
);
