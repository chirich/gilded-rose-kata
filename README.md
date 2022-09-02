This is my version of the kata GildedRose-Refactoring. The steps I took to implement it are:

1. correct the single unit test
2. create unit tests for existing business rules and check they all pass
3. refactor the method updateQuality to reduce its cognitive complexity
4. run the unit tests again and fix the refactoring
5. add unit test for Conjured items quality depreciation and check that it fails
5. add logic for Conjured items and check that the corresponding unit test passes
6. scanned code with SonarLint and Better Code Hub
