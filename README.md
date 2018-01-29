You are tasked with calculating the number of full days
elapsed in between start and end dates. The first and the
last day are considered partial days and never counted.
Following this logic, an experiment that has run from
1972-11-07 to 1972-11-08 should return 0, because there
are no fully elapsed days contained in between those dates,
and 2000-01-01 to 2000-01-03 should return 1. The solution
needs to cater for all valid dates between 1901-01-01 and
2999-12-31.

Implement a command line based system with at least one
way of providing input and output on the terminal. Although
it should obvious, make sure the solution compiles and
works.

Although any dates specified within the valid date range
listed above should work, here are a few test cases to
validate the output of your program.

TEST CASES
1. 1983-06-02 – 1983-06-22: 19 days
2. 1984-07-04 – 1984-12-25: 173 days
3. 989-01-03 – 1983-08-03: 1979 days


Solution:

Aim is to calculate the number of days with as less calculation as possible.

- For years add 365 or 366 (leap) days.
- For months add 31, 30, 28, 29 (leap) days.

Logic moves the two dates to start of the year.

E.g. start date is 15th March 2000, end date is 29th Jan 2004

Days to move 15th March to 1st Jan 2000 = 75 (considering leap year)
Days to move 29th Jan 2004 to 1st Jan 2004 = 29

Number of days between dates is : 29 - 75 + 366 (for 2000) + 365 ( for 2001) + 365 (2002) + 365 (2003) - 1 (as we don't want consider start and end date) = 1414



How to run:

From the root of the project

Compile
javac -d classes -cp "lib/junit-4.12.jar" src/au/com/qantas/*.java test/au/com/qantas/*.java

Run
java -cp "classes" au.com.qantas.MainClass