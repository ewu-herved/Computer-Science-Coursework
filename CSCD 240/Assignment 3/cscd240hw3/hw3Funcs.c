//Dan Herve
//CSCD 240: HW3

#include "hw3.h"

int countRecords(FILE * fin, int lines){

    int count = 0;
    char buffer[100];

    while (!feof(fin)) {

        fgets(buffer, 100, fin);
        count++;
    }

    count /= lines;

    rewind(fin);

    return count;
}

void buildList(LinkedList *myList, FILE *fin, int total) {

    int x = 0;
    int y = 0;
    Node *curr = NULL;
    char buffer[100];
    Company *tempCo;
    Stock *tempSt;
    int tempShares = 0;
    double tempPrice = 0.0;

    for(x = 0; x < total; x++) {

        tempCo = (Company*)calloc(1, sizeof(Company));
        tempSt = (Stock*)calloc(1, sizeof(Stock));

        fscanf(fin, "%s", buffer);



            if(search(myList, buffer) == 1) {

                for (curr = myList->head; curr != NULL; curr = curr->next) {

                    if (strcmp(buffer, curr->data->company.symbol) == 0) {

                        fgets(buffer, 100, fin);
                        strip(buffer);
                        fscanf(fin, "%lf", &tempPrice);
                        fscanf(fin, "%d", &tempShares);
                        curr->data->shares = curr->data->shares + tempShares;
                        curr->data->price = ((curr->data->shares * curr->data->price) + (tempShares * tempPrice)) / (tempShares + curr->data->shares);
                    }
                }
                free(tempCo);
                free(tempSt);
            }

            else {

                tempCo->symbol = (char*)calloc(strlen(buffer) + 1, sizeof(char));
                strcpy(tempCo->symbol, buffer);

                fgets(buffer, 100, fin);
                strip(buffer);
                tempCo->name = (char*)calloc(strlen(buffer), sizeof(char));
                for(y = 0; y < strlen(buffer) - 1; y++) {

                    tempCo->name[y] = buffer[y + 1];
                }

                tempSt->company = *tempCo;

                free(tempCo);

                fscanf(fin, "%lf", &tempSt->price);
                fscanf(fin, "%d", &tempSt->shares);

                addLast(myList, tempSt);
            }
    }
}

int menu() {

    int choice = 0;
    int continueInput = 1;

    do {

        printf("Choose an option from the following list:\n1) Print stock values\n2) Buy stock\n3) Sell stock\n4) Print stock info\n5) Quit\n\nChoice: ");

        scanf("%d", &choice);

        while(fgetc(stdin) != '\n');

        printf("\n\n");

        if(choice < 6 && choice > 0)
            continueInput = 0;

    } while(continueInput == 1);

    return choice;
}

void printStockValue(LinkedList *myList){

    char buffer[10];
    double curValue = 0.0;
    double totCurVal = 0.0;
    double profitLoss = 0.0;
    double totPurVal = 0.0;
    Node * curr = NULL;
    Stock *temp = NULL;
    int hasStock = 0;
    FILE * prices = openInputFile();

    while(!feof(prices)) {

        for(curr = myList->head; curr != NULL; curr = curr->next) {

            fscanf(prices, "%s%lf", buffer, &curValue);

            temp = curr->data;
            if(strcmp(temp->company.symbol, buffer) == 0) {

                totCurVal += curValue * temp->shares;
                totPurVal += temp->price * temp->shares;
                hasStock = 1;
            }

            if(hasStock == 1) {

                if(totPurVal - totCurVal > 0)
                    profitLoss = totPurVal - totCurVal;
                else
                    profitLoss = totCurVal - totPurVal;

                printf("%s current price $%.2lf\n\tCurrent Value: $%.2lf\n\tPurchase Value: $%.2lf\n\tProfit/Loss: ($%.2lf)\n\n", temp->company.name, curValue, totCurVal, totPurVal, profitLoss);
            }
            hasStock = 0;
        }
    }
    fclose(prices);
}

void buyStock(LinkedList *myList, int *total){

    Company *tempCo;
    Stock *tempSt;
    Stock *temp = NULL;
    Node *curr = NULL;
    char buffer[100];
    int purchase = 0;
    double price = 0.0;
    int exists = 0;

    printf("Enter the symbol of a company whose stock you'd like to purchase: ");
    scanf("%s", buffer);
    printf("\n");

    for(curr = myList->head; curr != NULL; curr = curr->next){

        temp = curr->data;
        if(strcmp(temp->company.symbol, buffer) == 0) {

            printf("How many shares would you like to purchase?: ");
            scanf("%d", &purchase);
            printf("\nWhat is the purchase price: $");
            scanf("%lf", &price);
            printf("\n");
            temp->shares += purchase;
            temp->price = ((purchase * price) + (temp->shares * temp->price)) / (temp->shares + purchase);
            exists = 1;
        }
    }

    if(exists == 0) {

        tempCo = (Company*)calloc(1, sizeof(Company));
        tempSt = (Stock*)calloc(1, sizeof(Stock));

        tempCo->symbol = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(tempCo->symbol, buffer);

        printf("What is the full name of the company you're buying from?: ");
        while(fgetc(stdin) != '\n');
        fgets(buffer, 100, stdin);
        strip(buffer);
        printf("\nHow many shares would you like to purchase?: ");
        scanf("%d", &purchase);
        printf("\nWhat is the purchase price: $");
        scanf("%lf", &price);
        printf("\n");

        tempCo->name = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(tempCo->name, buffer);

        tempSt->company = *tempCo;

        free(tempCo);

        tempSt->price = price;
        tempSt->shares = purchase;

        addLast(myList, tempSt);
    }
}

void sellStock(LinkedList *myList, int *total){

    char buffer[100];
    Stock *temp = NULL;
    int toSell = 0;
    Node *curr = NULL;
    int exists = 0;
    int continueInput = 1;

    printf("Enter the symbol of the company whose stock you'd like to sell: ");
    scanf("%s", buffer);
    printf("\n");

    for(curr = myList->head; curr != NULL; curr = curr->next) {

        temp = curr->data;
        if(strcmp(buffer, temp->company.symbol) == 0) {

            while(continueInput == 1) {

                printf("How many shares would you like to sell: ");
                scanf("%d", &toSell);
                printf("\n");

                if(toSell > temp->shares) {

                    printf("You only have %d shares.\n\n", temp->shares);
                }
                else {

                    temp->shares -= toSell;
                    printf("You now have %d shares.\n\n", temp->shares);
                    continueInput = 0;
                }
                if(temp->shares == 0) {

                    removeByValue(myList, temp);
                }
            }

            exists = 1;
        }
    }
    if(exists == 0) {

        printf("You have no stocks with the given company.\n");
    }
}

void printStockInfo(LinkedList *myList){

    Node *curr = NULL;
    Stock *temp = NULL;

    if(myList == NULL || myList->head == NULL)
        printf("Empty List\n\n");
    else {

        for (curr = myList->head; curr != NULL; curr = curr->next){

            temp = curr->data;
            printf("%s(%s)\n\nShares: %d\n\nPrice: $%.2lf\n\n", temp->company.name, temp->company.symbol, temp->shares, temp->price);
        }
        printf("\n");
    }
}

void cleanUp(LinkedList * myList){ //free the Nodes

    Node *curr = NULL;
    Stock *temp = NULL;

    if(myList->size == 0);
    else {

        for(curr = myList->head; curr != NULL; curr = myList->head){

            myList->head = myList->head->next; //chop off the first node
            temp = (*curr).data;

            free(temp->company.name);
            free(temp->company.symbol);
            //free(&(temp->company));
            free(temp);
            free(curr);
            myList->size--;
        }
    }
}

void strip(char str[]) {

    int x = 0;

    while(str[x] != '\r' && str[x] != '\n' && str[x] != '\0') {

        x++;
    }
    str[x] = '\0';
}
