# ♕ BYU CS 240 Chess

This project demonstrates mastery of proper software design, client/server architecture, networking using HTTP and WebSocket, database persistence, unit testing, serialization, and security.

## 10k Architecture Overview

The application implements a multiplayer chess server and a command line chess client.

[![Sequence Diagram](10k-architecture.png)](https://sequencediagram.org/index.html#initialData=C4S2BsFMAIGEAtIGckCh0AcCGAnUBjEbAO2DnBElIEZVs8RCSzYKrgAmO3AorU6AGVIOAG4jUAEyzAsAIyxIYAERnzFkdKgrFIuaKlaUa0ALQA+ISPE4AXNABWAexDFoAcywBbTcLEizS1VZBSVbbVc9HGgnADNYiN19QzZSDkCrfztHFzdPH1Q-Gwzg9TDEqJj4iuSjdmoMopF7LywAaxgvJ3FC6wCLaFLQyHCdSriEseSm6NMBurT7AFcMaWAYOSdcSRTjTka+7NaO6C6emZK1YdHI-Qma6N6ss3nU4Gpl1ZkNrZwdhfeByy9hwyBA7mIT2KAyGGhuSWi9wuc0sAI49nyMG6ElQQA)

[![My_Sequence Diagram](My-SD.png)](https://sequencediagram.org/index.html?presentationMode=readOnly#initialData=IYYwLg9gTgBAwgGwJYFMB2YBQAHYUxIhK4YwDKKUAbpTngUSWDABLBoAmCtu+hx7ZhWqEUdPo0EwAIsDDAAgiBAoAzqswc5wAEbBVKGBx2ZM6MFACeq3ETQBzGAAYAdAE5M9qBACu2GADEaMBUljAASij2SKoWckgQaIEA7gAWSGBiiKikALQAfOSUNFAAXDAA2gAKAPJkACoAujAA9D4GUAA6aADeAETtlMEAtih9pX0wfQA0U7jqydAc45MzUyjDwEgIK1MAvpjCJTAFrOxclOX9g1AjYxNTs33zqotQyw9rfRtbO58HbE43FgpyOonKUCiMUyUAAFJForFKJEAI4+NRgACUh2KohOhVk8iUKnU5XsKDAAFUOrCbndsYTFMo1Kp8UYdKUAGJITgwamURkwHRhOnAUaYRnElknUG4lTlNA+BAIHEiFRsyXM0kgSFyFD8uE3RkM7RS9Rs4ylBQcDh8jqM1VUPGnTUk1SlHUoPUKHxgVKw4C+1LGiWmrWs06W622n1+h1g9W5U6Ai5lCJQpFQSKqJVYFPAmWFI6XGDXDp3SblVZPQN++oQADW6ErU32jsohfgyHM5QATE4nN0y0MxWMYFXHlNa6l6020C3Vgd0BxTF5fP4AtB2OSYAAZCDRJIBNIZLLdvJF4ol6p1JqtAzqBJoIei0azF5vDgHYsgwr5ks9K+KDvvorxLAC5wFrKaooKUCAHjysL7oeqLorE2IJoYLphm6ZIUgatLlqOJpEuGFocjA3K8kBMAAGbeMMMA3KGpFup2mHlEBjrOgSOEsnhYBVKBn6cgxBp3IRI6jCRTJsZGFFUbaH5LHRDFMR0LGydKSaXjB5QgNAkLgEJCxLNxia6U68owDEACycggOkDgmWB7ywsp7zTAZUBGYJwlLBhcpYbxrH8TA5JgLGM6Nugkm3MRmlmhG0FWbBMDTrO6DmVhyaQZc8EoWouaYP+IIpQBGUxWg35XmVhTZD2MD9k4MBDpVc5Lpwq7eH4gReCg6B7gevjMMe6SZJgDUXkU1DXtIACiu7zfU83NC0D6qE+3TtVlP5sqVpQ9Dt1UlXlv4zalcHDb6SHXWAqEYoFMEanxpLhfhHSiRAwxRZlaABkGf0yUl5HlIp6lSYY9HfRDUCJWROkXeCsN3NlL2hW9kLDBANBRYycX0vDcmFJa6bYzQ6WA1Vqkw3j2hE9pJMUZE5OGDR0OMXT8ho9hGPujAWM4ygADio740BwMI0z5Qs0L4WjgAktINOMaLowOq6jPsjLGxyyemTiaOKswGrKAa69EbS2Tcs6AgoANobozG6b5t86D1sU-Yo4AHJGxzJti-TmvmvJOus-LTv+y79OYZ2B3ISN2bFaV7G1YdirKjVs11V2ORgH2A6tb0GcIJ1K6eD1G6Qrau7QgHoysmNp6TeezDlWmFTC8ta1e6M21U3O7bnQdR0D+gEFAh2KXgr3ai17ESHQqbqgPehPMhVpb0Rb9VUA3WVWS8T2uUTytrHcbXPAAzIfT9Zx3rzIFsCcv89gLCh9a6T4Oz0rzuB9zwdLbH3BvrfURFI5qWjgAi27twa23to7KGkD-5X0AbA0+EcUC+wgTDKBqCYGhxPryWef91ZBwIbfWC-RZ6qHGJUHoP9pDTFAYg6Y8CQAO3AcBWe2CUB7GmC4QRjQs6pTjmdUor9l5JwQHmM6qds6HT6DQuhFQGGKyYSwrhbC7YcNYTw0c-DBEuGEUPTsU185NULkOJRo5aHlFUYw5h40wGQ20QgrR+jRiGKEWXbq65AjYB8FAbA3B4C6kyPXQwTcJrmLZD+extQGg91HP3fec4hyeL4aY3Kk80zHQyT7Axp1clxKCh6cJItRywjgBU02q8sQP0AQJHec497RTnB-EOVtwbn39pfa+yVLLI3vrHXmm9+YRVNrw2EmTOlAK-hgzJpCzbkLdojDiMAS6NKfjAT0epvYoGSFMqpsyBnu2jJg3hNkMAQEifGIK6Nxn6QqQco5VS5nnJtJg65kA7kxweWMpKzyvSZFNkrGZhTpJnMIRcxhPzbl4OhZQsk6ieY5NTKUGpILKmjGkbIkp6y06lhsaMJWdDGEiKnqccx9jmrNGsYw8l6jfEV38QESwKBlQQGSDAAAUhAHkkTAjsIbC3POpSFGVCqJSO8LRZ6pPaegIcITgAcqgHACA8EoCzApdkv84jKZpKVb0FVaqNVap1cy4pqYJWXQAFYCrQKbWE-KeR1JQGiR62y+bNLHv9Y6HzCE9L9RfIMrtxnyMuoaxVaBvVPPelST6DEWmxQDdC7pGD2ZqWYmgwlekUajjjUChNYLpAQtJdIQNGbiHqOWeGkGeao2MKLeGAS5jzXQGqa3DtUAq3AIwe2zV0BEF1tWRGxtyMtmjI3sWgwYBB1asQQTUc0wF3QD7aTYAXy11QBHTyX5iLRnouBKUV1TrRx4utVBduVwS6UpzjSyodKi49DvWYLqrLeoBC8KqrsXpYDAGwCEwg8REgpGcWK8wtq5qLWWqtVoxg9VnFyeURA-6FBAfqVeqeQz5QgG4HgDD2Au3ocwx6tCDTp2Px9QLXWuMw3aHfum4+ssKa9LUv03NVtWNsy4aGuM-znqAtbbR1meCmNcZY3RwwcKo4oOY6THjMBNGQ1HdAtZ3HpNCh0Zw1TcmyHqfHZp8OSz9MrMMw24zcsSFmfuUJmdInBY0ANPjDdzMtNZphi5sdlmpPhw8raf23mLNSz83LH42xjbBfwWsyhmylQqiPfqlDaHCNkZzDI7DOd4mljfXtRGj7movrfcuTAQA)

## Modules

The application has three modules.

- **Client**: The command line program used to play a game of chess over the network.
- **Server**: The command line program that listens for network requests from the client and manages users and games.
- **Shared**: Code that is used by both the client and the server. This includes the rules of chess and tracking the state of a game.

## Starter Code

As you create your chess application you will move through specific phases of development. This starts with implementing the moves of chess and finishes with sending game moves over the network between your client and server. You will start each phase by copying course provided [starter-code](starter-code/) for that phase into the source code of the project. Do not copy a phases' starter code before you are ready to begin work on that phase.

## IntelliJ Support

Open the project directory in IntelliJ in order to develop, run, and debug your code using an IDE.

## Maven Support

You can use the following commands to build, test, package, and run your code.

| Command                    | Description                                     |
| -------------------------- | ----------------------------------------------- |
| `mvn compile`              | Builds the code                                 |
| `mvn package`              | Run the tests and build an Uber jar file        |
| `mvn package -DskipTests`  | Build an Uber jar file                          |
| `mvn install`              | Installs the packages into the local repository |
| `mvn test`                 | Run all the tests                               |
| `mvn -pl shared test`      | Run all the shared tests                        |
| `mvn -pl client exec:java` | Build and run the client `Main`                 |
| `mvn -pl server exec:java` | Build and run the server `Main`                 |

These commands are configured by the `pom.xml` (Project Object Model) files. There is a POM file in the root of the project, and one in each of the modules. The root POM defines any global dependencies and references the module POM files.

## Running the program using Java

Once you have compiled your project into an uber jar, you can execute it with the following command.

```sh
java -jar client/target/client-jar-with-dependencies.jar

♕ 240 Chess Client: chess.ChessPiece@7852e922
```
