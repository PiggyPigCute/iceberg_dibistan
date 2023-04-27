
# iceberg_dibistan

Website and Discord bot for Dibistan's Iceberg. Can be fork to create another iceberg. An iceberg rank all references to a world by there celebrity.

You can find the website at ... (not open yet).

# Algo

## Step 0 - Propositions

A proposition is a reference to Dibistan's world. All propositions are in a .txt file (one per line). At the beginning the program read the file, and save all propositions in a database.

We can add propositions later.

## Step 1 - get data

### User side

The program select 2 propositions.

The website ask if the user better know proposition 1 than proposition 2, or proposition 2 than proposition 1. User can also skip.

### Server side

The answer add 1 (or -1) to the link between the propositions. The link is oriented.

## Step 2 - transform data

If there is cycles, -1 to all links in the cycle.

## Step 3 - analyse data

We count a many path end to each node and rank propositions.

## Step 4 - show


