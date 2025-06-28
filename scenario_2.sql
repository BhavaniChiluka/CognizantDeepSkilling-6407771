DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, Balance
        FROM Customers
        WHERE Balance > 10000;

BEGIN
    FOR cust IN cur_customers LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;
    END LOOP;

    COMMIT;
END;
