## Assumption
- income should be positive number
- Runtime required JDK1.8
- machine installed maven

## build
```aidl
cd PaymentCalculator
mvn pckage
```

## Run
- if name is "David Chow"
- if income is 135000
```aidl
cd target
java -jar  PaymentCalculator-0.0.1-SNAPSHOT.jar "David Chow" 135000
```

## result
```aidl
Monthly Payslip for:"David Chow"
Gross Monthly Income:$11250
Monthly Income Tax:$2208
Net Monthly Income:$9042

```# PaymentCalculator
