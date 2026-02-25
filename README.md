# Java-Music-Library-Parser
This system processes raw text files containing music album metadata—including artists, release years, and track durations—to generate comprehensive library analytics. It utilizes custom data structures to handle time-based calculations and implements multi-criteria sorting algorithms.
Key Features

***Complex Data Parsing***: Utilizes Regular Expressions (Regex) to extract nested metadata (years, titles, durations) from non-uniform string formats.

***Custom Time Engine***: Implemented a Duration class to handle arithmetic logic for hours, minutes, and seconds, bypassing standard library limitations for custom formatting.

***Multi-Level Sorting***: Custom Comparator logic that sorts collections by Artist (alphabetical) and Year (chronological).

Library Statistics: Automated reporting for total collection playtime, shortest/longest tracks, and artist-specific analytics.

## Tech Stack
Language: Java (JDK 11+)

*Concepts*:     Object-Oriented Programming (Encapsulation, Composition), File I/O, Regex, Interface Implementation (Comparable).

## Architecture & OOP Design
The system is built on a modular hierarchy to ensure scalability:

AlbumDatabase: The entry point; handles file stream processing and exception management.

AlbumCollection: A wrapper for ArrayList<Album> providing high-level sorting and aggregate data.

Album: Models the relationship between artists and their tracks.

Duration: A utility class implementing Comparable to facilitate time-based sorting and math.

## Getting Started
Prerequisites

Java Development Kit (JDK) 11 or higher.

Installation & Execution

Clone the repository:
Bash

  ```
  git clone https://github.com/your-username/Music-Library-Parser.git
  ```

Compile the source files:
Bash

  ```
  javac *.java
  ```

Run the database parser:
Bash

  ```
  java AlbumDatabase
  ```

###   Challenges & Learning Outcomes
Data Sanitization: Solved the challenge of parsing varied text patterns (e.g., years in parentheses) using specific Regex patterns to ensure 100% data integrity during ingestion.

  Memory Efficiency: Optimized the AlbumCollection to handle large text files by utilizing StringBuilder for report generation, significantly reducing heap overhead compared to standard string concatenation.

Note: This project was developed as part of the CMP-4008Y module at the University of East Anglia (UEA).
