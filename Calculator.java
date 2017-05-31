package com.example.gamecoursework.game;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Calculator extends AppCompatActivity {

    final int late = 10000;
    int loopEffect = 10;
    String gameType;
    TextView timerBox;
    TextView answerBox;
    String display = "?";
    Button hasButton;
    TextView questionBox;
    CountDownTimer countDownTimer;
    String[] operations = {"+", "-", "*", "/"};
    Random random = new Random();
    int finalAnswer;
    String question;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        gameType = getIntent().getStringExtra("gameType");
        hasButton = (Button) findViewById(R.id.valueAT);
        timerBox = (TextView) findViewById(R.id.timer);
        answerBox = (TextView) findViewById(R.id.answer);
        questionBox = (TextView) findViewById(R.id.question);
        handlingQuestion();
        answerBox.setText(display);
        display = "";
        startClock();

    }

    private void handlingQuestion() {
        if (gameType.equals("novice")) {
            thread = new Thread() {
                public void run() {
                    for (int i = 0; i < loopEffect; i++) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                noviceLevel(generatinOperation(gameType), genaratingNumber(gameType), gameType);
                            }
                        });

                        try {
                            thread.sleep(late);


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Calculator.this, TimeOut.class);
                                startActivity(intent);
                                startClock();
                            }
                        });

                    }
                }
            };
            thread.start();
        } else if (gameType.equals("easy")) {
            // easy question
            thread = new Thread() {
                public void run() {
                    for (int i = 0; i < loopEffect; i++) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                easyLevel(generatinOperation(gameType), genaratingNumber(gameType), gameType);
                            }
                        });

                        try {
                            thread.sleep(late);


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Calculator.this, TimeOut.class);
                                startActivity(intent);
                                startClock();
                            }
                        });
                    }
                }
            };
            thread.start();
        } else if (gameType.equals("medium")) {

            thread = new Thread() {
                public void run() {
                    for (int i = 0; i < loopEffect; i++) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mediumLevel(generatinOperation(gameType), genaratingNumber(gameType), gameType);
                            }
                        });

                        try {
                            thread.sleep(late);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Calculator.this, TimeOut.class);
                                startActivity(intent);
                                startClock();
                            }
                        });
                    }
                }
            };
        } else if (gameType.equals("guru")) {
            // guru question
            thread = new Thread() {
                public void run() {
                    for (int i = 0; i < loopEffect; i++) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                guruLevel(generatinOperation(gameType), genaratingNumber(gameType), gameType);
                            }
                        });

                        try {
                            thread.sleep(late);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Calculator.this, TimeOut.class);
                                startActivity(intent);
                                startClock();
                            }
                        });
                    }
                }
            };
        } else {
            Log.d("Question level", "wrong Question Type ");
        }
    }


    private void startClock() {
        timerBox.setText("00 : 10");
        countDownTimer = new CountDownTimer(10 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerBox.setText("00 : 0" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

            }


        };
        countDownTimer.start();
    }


    public void onClickMinus(View view) {
        display += "-";
        updateScreen();
    }


    public void onClickHashTag(View view) {
        Intent intent;
        if (Integer.parseInt(display) == finalAnswer) {

            intent = new Intent(Calculator.this, CorrectAnswer.class);
            startActivity(intent);
        } else {

            intent = new Intent(Calculator.this, WrongAnswer.class);
            startActivity(intent);
        }
        display = "";
        updateScreen();
    }


    private String removeLastValue(String str) {
        try {
            str = str.substring(0, str.length() - 1);
            return str;
        } catch (Exception ex) {
            str = "";
            return str;
        }
    }

    private void clear() {
        display = removeLastValue(display);
    }

    public void onClickDelete(View view) {
        clear();
        updateScreen();
    }

    private void updateScreen() {
        answerBox.setText(display);
    }

    public void onClickNumber(View view) {
        Button button = (Button) view;
        display += button.getText();
        updateScreen();
    }

    private ArrayList<Integer> genaratingNumber(String gameLevel) {
        ArrayList<Integer> number = new ArrayList<Integer>();
        int changeNumber;
        if (gameLevel.equals("novice")) {
            for (int i = 0; i < 2; i++) {
                changeNumber = (int) random.nextInt(100) + 1;
                number.add(changeNumber);
            }
            return number;
        } else if (gameLevel.equals("easy")) {
            for (int i = 0; i < 3; i++) {
                changeNumber = (int) random.nextInt(100) + 1;
                number.add(changeNumber);
            }
            return number;
        } else if (gameLevel.equals("medium")) {
            for (int i = 0; i < 4; i++) {
                changeNumber = (int) random.nextInt(100) + 1;
                number.add(changeNumber);
            }
            return number;
        } else {
            for (int i = 0; i < 5; i++) {
                changeNumber = (int) random.nextInt(100) + 1;
                number.add(changeNumber);
            }
            return number;
        }
    }

    private ArrayList<Integer> generatinOperation(String gameLevel) {
        ArrayList<Integer> operations = new ArrayList<Integer>();
        if (gameLevel.equals("novice")) {
            int operationSign = (int) random.nextInt(4);
            operations.add(operationSign);
            return operations;
        } else if (gameLevel.equals("easy")) {
            for (int i = 0; i < 2; i++) {
                int operationSign = (int) random.nextInt(4);
                operations.add(operationSign);
            }
            return operations;
        } else if (gameLevel.equals("medium")) {
            for (int i = 0; i < 3; i++) {
                int operationSign = (int) random.nextInt(4);
                operations.add(operationSign);
            }
            return operations;
        } else {
            for (int i = 0; i < 4; i++) {
                int operationSign = (int) random.nextInt(4);
                operations.add(operationSign);
            }
            return operations;
        }
    }

    private void noviceLevel(ArrayList<Integer> operation, ArrayList<Integer> numbers, String gameLevel) {
        if (gameLevel.equals("novice")) {
            question = Integer.toString(numbers.get(0)) + operations[operation.get(0)]
                    + Integer.toString(numbers.get(1));
            questionBox.setText(question);

            if (operations[operation.get(0)].equals("/")) {
                finalAnswer = numbers.get(0) / numbers.get(1);
            } else if (operations[operation.get(0)].equals("*")) {
                finalAnswer = numbers.get(0) * numbers.get(1);
            } else if (operations[operation.get(0)].equals("+")) {
                finalAnswer = numbers.get(0) + numbers.get(1);
            } else if (operations[operation.get(0)].equals("-")) {
                finalAnswer = numbers.get(0) - numbers.get(1);
            }
        }
    }

    private void easyLevel(ArrayList<Integer> operation, ArrayList<Integer> numbers, String gameLevel) {
        if (gameLevel.equals("easy")) {
            question = Integer.toString(numbers.get(0)) + operations[operation.get(0)]
                    + Integer.toString(numbers.get(1)) + operations[operation.get(1)]
                    + Integer.toString(numbers.get(2));
            questionBox.setText(question);

            int subTotal = 0;
            if (operations[operation.get(0)].equals("+")) {
                subTotal = numbers.get(0) + numbers.get(1);
            } else if (operations[operation.get(0)].equals("-")) {
                subTotal = numbers.get(0) - numbers.get(1);
            } else if (operations[operation.get(0)].equals("*")) {
                subTotal = numbers.get(0) * numbers.get(1);
            } else if (operations[operation.get(0)].equals("/")) {
                subTotal = numbers.get(0) / numbers.get(1);
            }

            if (operations[operation.get(1)].equals("+")) {
                finalAnswer = subTotal + numbers.get(2);
            } else if (operations[operation.get(1)].equals("-")) {
                finalAnswer = subTotal - numbers.get(2);
            } else if (operations[operation.get(1)].equals("*")) {
                finalAnswer = subTotal * numbers.get(2);
            } else if (operations[operation.get(1)].equals("/")) {
                finalAnswer = subTotal / numbers.get(2);
            }

        }
    }


    private void mediumLevel(ArrayList<Integer> operation, ArrayList<Integer> numbers, String gameLevel) {
        if (gameLevel.equals("medium")) {
            question = Integer.toString(numbers.get(0)) + operations[operation.get(0)] + Integer.toString(1)
                    + operations[operation.get(1)] + Integer.toString(2) + operations[operation.get(2)]
                    + Integer.toString(numbers.get(3));
            questionBox.setText(question);

            int subTotal = 0;
            if (operations[operation.get(0)].equals("+")) {
                subTotal = numbers.get(0) + numbers.get(1);
            } else if (operations[operation.get(0)].equals("-")) {
                subTotal = numbers.get(0) - numbers.get(1);
            } else if (operations[operation.get(0)].equals("*")) {
                subTotal = numbers.get(0) * numbers.get(1);
            } else if (operations[operation.get(0)].equals("/")) {
                subTotal = numbers.get(0) / numbers.get(1);
            }

            int subSubTotal = 0;
            if (operations[operation.get(1)].equals("+")) {
                subSubTotal = subTotal + numbers.get(2);
            } else if (operations[operation.get(1)].equals("-")) {
                subSubTotal = subTotal - numbers.get(2);
            } else if (operations[operation.get(1)].equals("*")) {
                subSubTotal = subTotal * numbers.get(2);
            } else if (operations[operation.get(1)].equals("/")) {
                subSubTotal = subTotal / numbers.get(2);
            }

            if (operations[operation.get(2)].equals("+")) {
                finalAnswer = subSubTotal + numbers.get(3);
            } else if (operations[operation.get(2)].equals("-")) {
                finalAnswer = subSubTotal - numbers.get(3);
            } else if (operations[operation.get(2)].equals("*")) {
                finalAnswer = subSubTotal * numbers.get(3);
            } else if (operations[operation.get(2)].equals("/")) {
                finalAnswer = subSubTotal / numbers.get(3);
            }

        }
    }

    private void guruLevel(ArrayList<Integer> operation, ArrayList<Integer> numbers, String gameLevel) {
        if (gameLevel.equals("guru")) {
            question = Integer.toString(numbers.get(0)) + operations[operation.get(0)] + Integer.toString(1)
                    + operations[operation.get(1)] + Integer.toString(2) + operations[operation.get(2)]
                    + Integer.toString(numbers.get(3)) + operations[operation.get(3)]
                    + Integer.toString(numbers.get(4));
            questionBox.setText(question);


            int subTotal = 0;
            if (operations[operation.get(0)].equals("+")) {
                subTotal = numbers.get(0) + numbers.get(1);
            } else if (operations[operation.get(0)].equals("-")) {
                subTotal = numbers.get(0) - numbers.get(1);
            } else if (operations[operation.get(0)].equals("*")) {
                subTotal = numbers.get(0) * numbers.get(1);
            } else if (operations[operation.get(0)].equals("/")) {
                subTotal = numbers.get(0) / numbers.get(1);
            }

            int subSubTotal = 0;
            if (operations[operation.get(1)].equals("+")) {
                subSubTotal = subTotal + numbers.get(2);
            } else if (operations[operation.get(1)].equals("-")) {
                subSubTotal = subTotal - numbers.get(2);
            } else if (operations[operation.get(1)].equals("*")) {
                subSubTotal = subTotal * numbers.get(2);
            } else if (operations[operation.get(1)].equals("/")) {
                subSubTotal = subTotal / numbers.get(2);
            }
            int subSubSubTotal = 0;
            if (operations[operation.get(2)].equals("+")) {
                subSubSubTotal = subSubTotal + numbers.get(3);
            } else if (operations[operation.get(2)].equals("-")) {
                subSubSubTotal = subSubTotal - numbers.get(3);
            } else if (operations[operation.get(2)].equals("*")) {
                subSubSubTotal = subSubTotal * numbers.get(3);
            } else if (operations[operation.get(2)].equals("/")) {
                subSubSubTotal = subSubTotal / numbers.get(3);
            }

            if (operations[operation.get(3)].equals("+")) {
                finalAnswer = subSubSubTotal + numbers.get(4);
            } else if (operations[operation.get(3)].equals("-")) {
                finalAnswer = subSubSubTotal * numbers.get(4);
            } else if (operations[operation.get(3)].equals("*")) {
                finalAnswer = subSubSubTotal - numbers.get(4);
            } else if (operations[operation.get(3)].equals("/")) {
                finalAnswer = subSubSubTotal / numbers.get(4);
            }


        }
    }

}
