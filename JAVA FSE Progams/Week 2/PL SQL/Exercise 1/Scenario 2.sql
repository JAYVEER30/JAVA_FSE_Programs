BEGIN
    FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers WHERE Balance > 10000) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || rec.CustomerID || 
                             ', Name: ' || rec.Name ||
                             ' has been promoted to VIP. Balance: $' || rec.Balance);
    END LOOP;

    COMMIT;
END;