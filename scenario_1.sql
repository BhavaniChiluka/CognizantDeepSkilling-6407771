DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, InterestRate, Age
        FROM Customers
        WHERE Age > 60;

BEGIN
    FOR cust IN cur_customers LOOP
        UPDATE Customers
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;
    END LOOP;

    COMMIT;
END;
