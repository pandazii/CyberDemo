package dehaagsehogeschool.digiveilig.spel.games;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import dehaagsehogeschool.digiveilig.BaseActivity;
import dehaagsehogeschool.digiveilig.GameSettings;
import dehaagsehogeschool.digiveilig.enums.Game;
import dehaagsehogeschool.digiveilig.managers.GameManager;
import dehaagsehogeschool.digiveilig.models.GameManagerSettings;
import dehaagsehogeschool.digiveilig.R;
import dehaagsehogeschool.digiveilig.interfaces.ActivityInterface;

public class MemoryActivity extends BaseActivity implements ActivityInterface {

    //Card buttons
    private ImageView card_1, card_2, card_3, card_4, card_5, card_6, card_7, card_8,
            card_9, card_10, card_11, card_12, card_13, card_14, card_15, card_16;

    private TextView gameTimer;

    //Memory card images
    private int cardImage101, cardImage102, cardImage103, cardImage104, cardImage105, cardImage106, cardImage107, cardImage108,
            cardImage201, cardImage202, cardImage203, cardImage204, cardImage205, cardImage206, cardImage207, cardImage208;

    private Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108,
            201, 202, 203, 204, 205, 206, 207, 208};

    private int firstCard, secondCard;
    private int clickedFirst, clickedSecond;
    private int cardNumber = 1;
    private Random random = new Random();
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_activity);

        initializeObjects();
        initializeCardsImages();
        shuffleCards(cardsArray);
        initializeGameManager();
    }

    private void initializeGameManager(){
        GameManagerSettings settings = new GameManagerSettings();
        settings.gameTime = 100;
        settings.context = this;
        settings.gameTimer = gameTimer;
        settings.secondsForZeroStars = 90;
        settings.secondsForOneStar = 70;
        settings.secondsForTwoStars = 50;
        settings.secondsForThreeStars = 30;
        settings.levelId = getIntent().getExtras().getInt(GameSettings.LEVEL_ID);
        settings.game = Game.valueOf(getIntent().getExtras().getString(GameSettings.LEVEL_GAME));

        gameManager = new GameManager(settings);
    }

    @Override
    public void initializeObjects() {
        // Set level
        ((TextView) findViewById(R.id.memory_level_text))
                .setText("Level: " + Integer.toString(getIntent().getExtras().getInt(GameSettings.LEVEL_ID)));

        gameTimer = findViewById(R.id.inGameTimer);
        card_1 = findViewById(R.id.button1);
        card_1.setTag("0");
        card_2 = findViewById(R.id.button2);
        card_2.setTag("1");
        card_3 = findViewById(R.id.button3);
        card_3.setTag("2");
        card_4 = findViewById(R.id.button4);
        card_4.setTag("3");
        card_5 = findViewById(R.id.button5);
        card_5.setTag("4");
        card_6 = findViewById(R.id.button6);
        card_6.setTag("5");
        card_7 = findViewById(R.id.button7);
        card_7.setTag("6");
        card_8 = findViewById(R.id.button8);
        card_8.setTag("7");
        card_9 = findViewById(R.id.button9);
        card_9.setTag("8");
        card_10 = findViewById(R.id.button10);
        card_10.setTag("9");
        card_11 = findViewById(R.id.button11);
        card_11.setTag("10");
        card_12 = findViewById(R.id.button12);
        card_12.setTag("11");
        card_13 = findViewById(R.id.button13);
        card_13.setTag("12");
        card_14 = findViewById(R.id.button14);
        card_14.setTag("13");
        card_15 = findViewById(R.id.button15);
        card_15.setTag("14");
        card_16 = findViewById(R.id.button16);
        card_16.setTag("15");
    }

    public void buttonClick(View view) {
        int theCard;

        switch (view.getId()) {
            case R.id.button1:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_1, theCard);
                break;
            case R.id.button2:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_2, theCard);
                break;
            case R.id.button3:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_3, theCard);
                break;
            case R.id.button4:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_4, theCard);
                break;
            case R.id.button5:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_5, theCard);
                break;
            case R.id.button6:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_6, theCard);
                break;
            case R.id.button7:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_7, theCard);
                break;
            case R.id.button8:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_8, theCard);
                break;
            case R.id.button9:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_9, theCard);
                break;
            case R.id.button10:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_10, theCard);
                break;
            case R.id.button11:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_11, theCard);
                break;
            case R.id.button12:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_12, theCard);
                break;
            case R.id.button13:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_13, theCard);
                break;
            case R.id.button14:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_14, theCard);
                break;
            case R.id.button15:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_15, theCard);
                break;
            case R.id.button16:
                theCard = Integer.parseInt((String) view.getTag());
                checkCards(card_16, theCard);
                break;

        }

    }

    private void shuffleCards(Integer[] cards) {
        if (cards != null) {
            Collections.shuffle(Arrays.asList(cards));
        }
    }

    private void initializeCardsImages() {
        int levelId = getIntent().getExtras().getInt(GameSettings.LEVEL_ID);

        if (levelId == 1 || levelId == 5) {
            cardImage101 = R.drawable.creditcard;
            cardImage102 = R.drawable.death;
            cardImage103 = R.drawable.finding_document;
            cardImage104 = R.drawable.finding_password;
            cardImage105 = R.drawable.internet_trouble;
            cardImage106 = R.drawable.secret_identity;
            cardImage107 = R.drawable.target;
            cardImage108 = R.drawable.worm;

            cardImage201 = R.drawable.creditcard;
            cardImage202 = R.drawable.death;
            cardImage203 = R.drawable.finding_document;
            cardImage204 = R.drawable.finding_password;
            cardImage205 = R.drawable.internet_trouble;
            cardImage206 = R.drawable.secret_identity;
            cardImage207 = R.drawable.target;
            cardImage208 = R.drawable.worm;

        } else if (levelId == 3 || levelId == 7) {
            cardImage101 = R.drawable.hacker;
            cardImage102 = R.drawable.identity_theft;
            cardImage103 = R.drawable.killer_usb;
            cardImage104 = R.drawable.mail_phishing;
            cardImage105 = R.drawable.password;
            cardImage106 = R.drawable.spam;
            cardImage107 = R.drawable.trojan_horse;
            cardImage108 = R.drawable.web_phishing;

            cardImage201 = R.drawable.hacker;
            cardImage202 = R.drawable.identity_theft;
            cardImage203 = R.drawable.killer_usb;
            cardImage204 = R.drawable.mail_phishing;
            cardImage205 = R.drawable.password;
            cardImage206 = R.drawable.spam;
            cardImage207 = R.drawable.trojan_horse;
            cardImage208 = R.drawable.web_phishing;

        } else if (levelId == 13) {
            cardImage101 = R.drawable.creditcard;
            cardImage102 = R.drawable.death;
            cardImage103 = R.drawable.finding_document;
            cardImage104 = R.drawable.finding_password;
            cardImage105 = R.drawable.internet_trouble;
            cardImage106 = R.drawable.secret_identity;
            cardImage107 = R.drawable.target;
            cardImage108 = R.drawable.worm;

            cardImage201 = R.drawable.creditcard_text;
            cardImage202 = R.drawable.death_text;
            cardImage203 = R.drawable.finding_document_text;
            cardImage204 = R.drawable.finding_password_text;
            cardImage205 = R.drawable.internet_trouble_text;
            cardImage206 = R.drawable.secret_identity_text;
            cardImage207 = R.drawable.target_text;
            cardImage208 = R.drawable.worm_text;

        } else if (levelId == 15) {
            cardImage101 = R.drawable.hacker;
            cardImage102 = R.drawable.identity_theft;
            cardImage103 = R.drawable.killer_usb;
            cardImage104 = R.drawable.mail_phishing;
            cardImage105 = R.drawable.password;
            cardImage106 = R.drawable.spam;
            cardImage107 = R.drawable.trojan_horse;
            cardImage108 = R.drawable.web_phishing;

            cardImage201 = R.drawable.hacker_text;
            cardImage202 = R.drawable.identity_theft_text;
            cardImage203 = R.drawable.killer_usb_text;
            cardImage204 = R.drawable.mail_phishing_text;
            cardImage205 = R.drawable.password_text;
            cardImage206 = R.drawable.spam_text;
            cardImage207 = R.drawable.trojan_horse_text;
            cardImage208 = R.drawable.web_phishing_text;
        }
    }

    private void checkCards(ImageView cards, int card) {

        if (cardsArray[card] == 101) {
            cards.setImageResource(cardImage101);
        } else if (cardsArray[card] == 102) {
            cards.setImageResource(cardImage102);
        } else if (cardsArray[card] == 103) {
            cards.setImageResource(cardImage103);
        } else if (cardsArray[card] == 104) {
            cards.setImageResource(cardImage104);
        } else if (cardsArray[card] == 105) {
            cards.setImageResource(cardImage105);
        } else if (cardsArray[card] == 106) {
            cards.setImageResource(cardImage106);
        } else if (cardsArray[card] == 107) {
            cards.setImageResource(cardImage107);
        } else if (cardsArray[card] == 108) {
            cards.setImageResource(cardImage108);
        } else if (cardsArray[card] == 201) {
            cards.setImageResource(cardImage201);
        } else if (cardsArray[card] == 202) {
            cards.setImageResource(cardImage202);
        } else if (cardsArray[card] == 203) {
            cards.setImageResource(cardImage203);
        } else if (cardsArray[card] == 204) {
            cards.setImageResource(cardImage204);
        } else if (cardsArray[card] == 205) {
            cards.setImageResource(cardImage205);
        } else if (cardsArray[card] == 206) {
            cards.setImageResource(cardImage206);
        } else if (cardsArray[card] == 207) {
            cards.setImageResource(cardImage207);
        } else if (cardsArray[card] == 208) {
            cards.setImageResource(cardImage208);
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            cards.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            changeCardStatus(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();

                }
            }, 1000);
        }
    }

    private void changeCardStatus(boolean status) {

        card_1.setEnabled(status);
        card_2.setEnabled(status);
        card_3.setEnabled(status);
        card_4.setEnabled(status);
        card_5.setEnabled(status);
        card_6.setEnabled(status);
        card_7.setEnabled(status);
        card_8.setEnabled(status);
        card_9.setEnabled(status);
        card_10.setEnabled(status);
        card_11.setEnabled(status);
        card_12.setEnabled(status);
        card_13.setEnabled(status);
        card_14.setEnabled(status);
        card_15.setEnabled(status);
        card_16.setEnabled(status);
    }

    private void calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                card_1.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                card_2.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                card_3.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                card_4.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                card_5.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                card_6.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                card_7.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                card_8.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                card_9.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                card_10.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                card_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                card_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                card_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                card_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                card_15.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                card_16.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                card_1.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                card_2.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                card_3.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                card_4.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                card_5.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                card_6.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                card_7.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                card_8.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                card_9.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                card_10.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                card_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                card_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                card_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                card_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                card_15.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                card_16.setVisibility(View.INVISIBLE);
            }


        } else {
            card_1.setImageResource(R.drawable.memory_card);
            card_2.setImageResource(R.drawable.memory_card);
            card_3.setImageResource(R.drawable.memory_card);
            card_4.setImageResource(R.drawable.memory_card);
            card_5.setImageResource(R.drawable.memory_card);
            card_6.setImageResource(R.drawable.memory_card);
            card_7.setImageResource(R.drawable.memory_card);
            card_8.setImageResource(R.drawable.memory_card);
            card_9.setImageResource(R.drawable.memory_card);
            card_10.setImageResource(R.drawable.memory_card);
            card_11.setImageResource(R.drawable.memory_card);
            card_12.setImageResource(R.drawable.memory_card);
            card_13.setImageResource(R.drawable.memory_card);
            card_14.setImageResource(R.drawable.memory_card);
            card_15.setImageResource(R.drawable.memory_card);
            card_16.setImageResource(R.drawable.memory_card);

        }

        changeCardStatus(true);

        checkEnd();

    }

    private void checkEnd() {

        if (card_1.getVisibility() == View.INVISIBLE &&
                card_2.getVisibility() == View.INVISIBLE &&
                card_3.getVisibility() == View.INVISIBLE &&
                card_4.getVisibility() == View.INVISIBLE &&
                card_5.getVisibility() == View.INVISIBLE &&
                card_6.getVisibility() == View.INVISIBLE &&
                card_7.getVisibility() == View.INVISIBLE &&
                card_8.getVisibility() == View.INVISIBLE &&
                card_9.getVisibility() == View.INVISIBLE &&
                card_10.getVisibility() == View.INVISIBLE &&
                card_11.getVisibility() == View.INVISIBLE &&
                card_12.getVisibility() == View.INVISIBLE &&
                card_13.getVisibility() == View.INVISIBLE &&
                card_14.getVisibility() == View.INVISIBLE &&
                card_15.getVisibility() == View.INVISIBLE &&
                card_16.getVisibility() == View.INVISIBLE
                ) {
            gameManager.gameEnded = true;
        }
    }

    private void stopGame() {
        super.onBackPressed();
        super.finish();
        gameManager.stopTimer();
    }

    @Override
    public void onBackPressed() {
        stopGame();
    }

    public void stopMemory(View view) {
        stopGame();
    }
}
