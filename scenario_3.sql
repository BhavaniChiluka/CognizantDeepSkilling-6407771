DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_customer_name VARCHAR2(100);
BEGIN
    FOR loan IN cur_loans LOOP
        SELECT Name INTO v_customer_name
        FROM Customers
        WHERE CustomerID = loan.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customer_name || ', your loan (ID: ' || loan.LoanID || ') is due on ' || TO_CHAR(loan.DueDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
