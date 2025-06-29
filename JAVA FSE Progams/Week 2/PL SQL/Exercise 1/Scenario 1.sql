BEGIN
    FOR rec IN (SELECT CustomerID, Name, InterestRate FROM Customers WHERE Age > 60) LOOP
        UPDATE Customers
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;

        -- Print message to show discount applied
        DBMS_OUTPUT.PUT_LINE('1% discount applied for Customer ID: ' || rec.CustomerID || 
                             ', Name: ' || rec.Name || 
                             ', New Rate: ' || TO_CHAR(rec.InterestRate - 1, '90.00'));
    END LOOP;

    COMMIT;
END;