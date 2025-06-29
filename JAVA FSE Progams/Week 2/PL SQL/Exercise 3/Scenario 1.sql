CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to AccountID: ' || rec.AccountID || 
                             ', New Balance: ' || TO_CHAR(rec.Balance * 1.01, '99999.99'));
    END LOOP;
    
    COMMIT;
END;