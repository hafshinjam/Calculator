package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mCalculatorScreen;
    private Button mEmptyButton;
    private Button mSignButton;
    private Button mDeleteButton;
    private Button mNineButton;
    private Button mEightButton;
    private Button mSevenButton;
    private Button mSixButton;
    private Button mFiveButton;
    private Button mFourButton;
    private Button mThreeButton;
    private Button mTwoButton;
    private Button mOneButton;
    private Button mZeroButton;
    private Button mDivisionButton;
    private Button mTimesButton;
    private Button mPlusButton;
    private Button mMinusButton;
    private Button mDotButton;
    private Button mEqualButton;
    private Double mResult = null;
    private String mOperation = "";
    private String mOperationShowText = "";
    private boolean mSign = false;
    private boolean mDecimalPointFlag = false;
    private boolean mDotUsed = false;
    public static final String CALCULATOR_OPERATION_STRING = "com.example.calculator.calculatorOperationString";
    public static final String DECIMAL_POINT_FLAG = "com.example.calculator.decimalPointFlag";
    public static final String DOT_USED_FLAG = "com.example.calculator.dotUsedFLag";
    public static final String SIGN_FLAG = "com.example.calculator.signFlag";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CALCULATOR_OPERATION_STRING, mOperationShowText);
        outState.putBoolean(DECIMAL_POINT_FLAG, mDecimalPointFlag);
        outState.putBoolean(DOT_USED_FLAG, mDotUsed);
        outState.putBoolean(SIGN_FLAG, mSign);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        findAllViews();
        if (savedInstanceState != null) {
            mOperationShowText = savedInstanceState.getString(CALCULATOR_OPERATION_STRING);
            mDecimalPointFlag = savedInstanceState.getBoolean(DECIMAL_POINT_FLAG);
            mDotUsed = savedInstanceState.getBoolean(DOT_USED_FLAG);
            mSign = savedInstanceState.getBoolean(SIGN_FLAG);
            mCalculatorScreen.setText(mOperationShowText);
        }
        setOnClickListeners();

    }

    public void findAllViews() {

        mCalculatorScreen = findViewById(R.id.calculatorScreen);
        mNineButton = findViewById(R.id.nineButton);
        mEightButton = findViewById(R.id.eightButton);
        mSevenButton = findViewById(R.id.sevenButton);
        mSixButton = findViewById(R.id.sixButton);
        mFiveButton = findViewById(R.id.fiveButton);
        mFourButton = findViewById(R.id.fourButton);
        mThreeButton = findViewById(R.id.threeButton);
        mTwoButton = findViewById(R.id.twoButton);
        mOneButton = findViewById(R.id.oneButton);
        mZeroButton = findViewById(R.id.zeroButton);
        mDeleteButton = findViewById(R.id.DeleteButton);
        mDivisionButton = findViewById(R.id.divisionButton);
        mPlusButton = findViewById(R.id.plusButton);
        mMinusButton = findViewById(R.id.minusButton);
        mDotButton = findViewById(R.id.dotButton);
        mTimesButton = findViewById(R.id.timesButton);
        mEqualButton = findViewById(R.id.equalButton);
        mEmptyButton = findViewById(R.id.EmptyButton);
        mSignButton = findViewById(R.id.signButton);
    }


    public void setOnClickListeners() {
        mDotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDecimalPointFlag = !mDecimalPointFlag;
            }
        });

        mEqualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseEquation();
                mCalculatorScreen.setText(String.valueOf(mResult));
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });
        mDeleteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mOperationShowText = "";
                mCalculatorScreen.setText(mOperationShowText);
                updateOperation();
                return true;
            }
        });

        mTimesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation("×");
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation("+");
            }
        });

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation("-");
            }
        });

        mDivisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation("÷");
            }
        });


        mSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSign = !mSign;
            }
        });

        mOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(1);
            }
        });
        mTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(2);
            }
        });
        mThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(3);
            }
        });
        mFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(4);
            }
        });
        mFiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(5);
            }
        });
        mSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(6);
            }
        });
        mSevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(7);
            }
        });
        mEightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(8);
            }
        });
        mNineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(9);
            }
        });
        mZeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToOperationText(0);
            }
        });
    }

    private void addOperation(String operation) {
        if (mOperationShowText.length() == 0)
            mOperationShowText += 0;
        else if (Character.isDigit(mOperationShowText.charAt(mOperationShowText.length() - 1))) {
            mOperationShowText += operation;
            mOperation += operation;
        } else {
            mOperationShowText = mOperationShowText.substring(0, mOperationShowText.length() - 1) + operation;
            mOperation = mOperation.substring(0, mOperation.length() - 1) + operation;
        }
        mDotUsed = false;
        mDecimalPointFlag = false;
    }

    private void addNumberToOperationText(int number) {
        if (mSign) {
            if (mOperationShowText.length() == 0) {
                if (mDecimalPointFlag) {
                    mOperationShowText += "n." + number;
                    mDotUsed = true;
                } else
                    mOperationShowText += "n" + number;
            } else if (!Character.isDigit(mOperationShowText.charAt(mOperationShowText.length() - 1))
                    && mOperationShowText.charAt(mOperationShowText.length() - 1) != 'n')
                if (mDecimalPointFlag && !mDotUsed) {
                    mOperationShowText += "n." + number;
                    mDotUsed = true;
                } else mOperationShowText += "n" + number;
        } else {
            if (mDecimalPointFlag && !mDotUsed) {
                mOperationShowText += "." + number;
                mDotUsed = true;
            } else
                mOperationShowText += number;
        }
        mCalculatorScreen.setText(mOperationShowText);
        if (mSign)
            mSign = false;
    }


    private void delete() {
        StringBuilder tempBuilder = new StringBuilder(mOperation);
        if (mOperationShowText.length() > 1) {
            if (!Character.isDigit(mOperationShowText.charAt(mOperationShowText.length() - 1))
                    && mOperationShowText.charAt(mOperationShowText.length() - 1) != 'n'
                    && mOperationShowText.charAt(mOperationShowText.length() - 1) != '.')
                mOperation = String.valueOf(tempBuilder.deleteCharAt(tempBuilder.length() - 1));
            mOperationShowText = mOperationShowText.substring(0, mOperationShowText.length() - 1);
        } else mOperationShowText = "";
        mCalculatorScreen.setText(mOperationShowText);
    }

    private void parseEquation() {
        if (!Character.isDigit(mOperationShowText.charAt(mOperationShowText.length() - 1)) && (mOperationShowText.charAt(mOperationShowText.length() - 1) != '.'))
            mOperationShowText = mOperationShowText.substring(0, mOperationShowText.length() - 1);
        for (int i = 0; i < mOperationShowText.length(); i++) {
            if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != '.')
                break;
            else if (i == mOperationShowText.length() - 1 && Character.isDigit(mOperationShowText.charAt(i)))
                mResult = Double.valueOf(mOperationShowText);
        }
        doMultiplication();
        updateSigns();
        doDivision();
        updateSigns();
        doAddition();
        doSubtraction();

    }

    private void doMultiplication() {
        //×
        double tempNumber1;
        double tempNumber2;
        int startIndex = 0, endIndex = 0;

        while (mOperationShowText.contains("×")) {
            for (int i = mOperationShowText.indexOf("×") - 1; i > 0; i--) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.') {
                    startIndex = i + 1;
                    break;
                }
            }
            for (int i = mOperationShowText.indexOf("×") + 1; i <= mOperationShowText.length() - 1; i++) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.' && i < mOperationShowText.length() - 1) {
                    endIndex = i;
                    break;
                }
                if (i == mOperationShowText.length() - 1)
                    endIndex = i;
            }
            tempNumber1 = Double.parseDouble(mOperationShowText.substring(startIndex, mOperationShowText.indexOf("×")).replace("n", "-"));
            if (endIndex != mOperationShowText.length() - 1)
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("×") + 1, endIndex).replace("n", "-"));
            else
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("×") + 1).replace("n", "-"));

            mult(tempNumber1, tempNumber2, startIndex, endIndex);
            updateOperation();
        }
    }

    private void doDivision() {
        //÷
        double tempNumber1;
        double tempNumber2;
        int startIndex = 0, endIndex = 0;

        while (mOperationShowText.contains("÷")) {
            for (int i = mOperationShowText.indexOf("÷") - 1; i > 0; i--) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.') {
                    startIndex = i + 1;
                    break;
                }
            }
            for (int i = mOperationShowText.indexOf("÷") + 1; i <= mOperationShowText.length() - 1; i++) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.' && i < mOperationShowText.length() - 1) {
                    endIndex = i;
                    break;
                }
                if (i == mOperationShowText.length() - 1)
                    endIndex = i;
            }
            tempNumber1 = Double.parseDouble(mOperationShowText.substring(startIndex, mOperationShowText.indexOf("÷")).replace("n", "-"));
            if (endIndex != mOperationShowText.length() - 1)
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("÷") + 1, endIndex).replace("n", "-"));
            else
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("÷") + 1).replace("n", "-"));

            div(tempNumber1, tempNumber2, startIndex, endIndex);
            updateOperation();
        }
    }

    private void doAddition() {
        //÷
        double tempNumber1;
        double tempNumber2;
        int startIndex = 0, endIndex = 0;

        while (mOperationShowText.contains("+")) {
            for (int i = mOperationShowText.indexOf("+") - 1; i > 0; i--) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.') {
                    startIndex = i + 1;
                    break;
                }
            }
            for (int i = mOperationShowText.indexOf("+") + 1; i <= mOperationShowText.length() - 1; i++) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.' && i < mOperationShowText.length() - 1) {
                    endIndex = i;
                    break;
                }
                if (i == mOperationShowText.length() - 1)
                    endIndex = i;
            }
            tempNumber1 = Double.parseDouble(mOperationShowText.substring(startIndex, mOperationShowText.indexOf("+")).replace("n", "-"));
            if (endIndex != mOperationShowText.length() - 1)
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("+") + 1, endIndex).replace("n", "-"));
            else
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("+") + 1).replace("n", "-"));

            add(tempNumber1, tempNumber2, startIndex, endIndex);
            updateOperation();
        }
    }

    private void doSubtraction() {
        //÷
        double tempNumber1;
        double tempNumber2;
        int startIndex = 0, endIndex = 0;

        while (mOperationShowText.contains("-")) {
            if (mOperationShowText.indexOf('-') == mOperationShowText.lastIndexOf('-') && mOperationShowText.indexOf('-') == 0)
                break;
            for (int i = mOperationShowText.indexOf("-") - 1; i > 0; i--) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.') {
                    startIndex = i + 1;
                    break;
                }
            }
            for (int i = mOperationShowText.indexOf("-") + 1; i <= mOperationShowText.length() - 1; i++) {
                if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                        && mOperationShowText.charAt(i) != '.' && i < mOperationShowText.length() - 1) {
                    endIndex = i;
                    break;
                }
                if (i == mOperationShowText.length() - 1)
                    endIndex = i;
            }
            tempNumber1 = Double.parseDouble(mOperationShowText.substring(startIndex, mOperationShowText.indexOf("-")).replace("n", "-"));
            if (endIndex != mOperationShowText.length() - 1)
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("-") + 1, endIndex).replace("n", "-"));
            else
                tempNumber2 = Double.parseDouble(mOperationShowText.substring(mOperationShowText.indexOf("-") + 1).replace("n", "-"));

            sub(tempNumber1, tempNumber2, startIndex, endIndex);
            updateOperation();
        }
    }


    private void updateOperation() {
        mOperation = "";
        for (int i = 0; i < mOperationShowText.length() - 1; i++) {
            if (!Character.isDigit(mOperationShowText.charAt(i)) && mOperationShowText.charAt(i) != 'n'
                    && mOperationShowText.charAt(i) != '.')
                mOperation += mOperationShowText.charAt(i);
        }
    }

    private void updateSigns() {
        mOperationShowText = mOperationShowText.replace("--", "+");
        mOperationShowText = mOperationShowText.replace("+-", "-");
    }


    private void mult(double tempNumber1, double tempNumber2, int startIndex, int endIndex) {
        mResult = tempNumber1 * tempNumber2;
        mOperationShowText = mOperationShowText.replace(mOperationShowText.substring(startIndex, endIndex), String.valueOf(mResult));
    }

    private void div(double tempNumber1, double tempNumber2, int startIndex, int endIndex) {
        mResult = tempNumber1 / tempNumber2;
        mOperationShowText = mOperationShowText.replace(mOperationShowText.substring(startIndex, endIndex), String.valueOf(mResult));
        if (mResult.isInfinite()) {
            mOperationShowText = "";
            Toast.makeText(MainActivity.this, R.string.division_failure, Toast.LENGTH_LONG).show();
        }
    }

    private void add(double tempNumber1, double tempNumber2, int startIndex, int endIndex) {
        mResult = tempNumber1 + tempNumber2;
        mOperationShowText = mOperationShowText.replace(mOperationShowText.substring(startIndex, endIndex), String.valueOf(mResult));
    }

    private void sub(double tempNumber1, double tempNumber2, int startIndex, int endIndex) {
        mResult = tempNumber1 - tempNumber2;

        mOperationShowText = mOperationShowText.replace(mOperationShowText.substring(startIndex, endIndex), String.valueOf(mResult));
    }
}
