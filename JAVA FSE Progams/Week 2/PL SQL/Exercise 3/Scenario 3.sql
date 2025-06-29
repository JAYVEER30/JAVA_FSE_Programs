CREATE OR REPLACE PROCEDURE TransferFunds(
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) IS
    insufficient_balance EXCEPTION;
    from_balance NUMBER;
BEGIN
    SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_account FOR UPDATE;

    IF from_balance < amount THEN
        RAISE insufficient_balance;
    ELSE
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = from_account;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = to_account;

        DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || amount || ' transferred from Account ' || 
                             from_account || ' to Account ' || to_account);
    END IF;

    COMMIT;

EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient funds in Account ' || from_account);
END;