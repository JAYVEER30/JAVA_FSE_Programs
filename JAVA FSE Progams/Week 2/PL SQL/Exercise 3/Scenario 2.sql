CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept IN VARCHAR2,
    bonus_pct IN NUMBER
) IS
BEGIN
    FOR rec IN (SELECT EmployeeID, Name, Salary FROM Employees WHERE Department = dept) LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * bonus_pct / 100)
        WHERE EmployeeID = rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee: ' || rec.Name ||
                             ', New Salary: ' || TO_CHAR(rec.Salary * (1 + bonus_pct / 100), '999999.99'));
    END LOOP;
    
    COMMIT;
END;