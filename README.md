# iceberg_dibistan

Website and Discord bot for Dibistan's Iceberg. Can be forked to create another iceberg. An iceberg ranks all references to a world according to their celebrity.

You can find the website at ... (not open yet).

# Algo

## Step 0 - Propositions

A proposition is a reference to Dibistan's world. All propositions are in a .txt file (one per line). At the beginning, the program read the file, and save all propositions in a database.

We can add propositions later.

## Step 1 - get data

### User side

The program select 2 propositions.

The website asks if the user knows proposition 1 better than proposition 2, or proposition 2 better than proposition 1. User can also skip.

### Server side

The server adjusts the link between the two propositions based on the answer. The link is oriented and has a numerical coefficient. If the coefficient is negative, the orientation will change, resulting in a positive coefficient.

## Step 2 - transform data

If there are cycles, -1 to all links in the cycle.

## Step 3 - analyze data

We count the number of paths that end at each node and then rank the propositions.

## Step 4 - show

We can now show the result. If a new vote or proposition arrives, we MUST use the old database, without step 2, and go back to step 1.
