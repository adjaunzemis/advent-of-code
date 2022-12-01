import numpy as np

def read_list_from_file(file: str) -> list:
    """Reads list from text file."""
    with open(file, "r") as f:
        lines = f.readlines()
        return [line.strip("\n") for line in lines]

def separate_list_by_empty_entry(input_list: list) -> list:
    """Creates list of lists from input list using empty entries as delimiter."""
    output_list = [[]]
    idx = 0
    for entry in input_list:
        if len(entry) > 0:
            if idx >= len(output_list):
                output_list.append([])
            output_list[idx].append(entry)
        else:
            idx += 1
    return output_list

if __name__ == "__main__":
    CALORIES_LIST_FILE = "./2022/andris/day1/day1_input1.txt"
    calories_list = read_list_from_file(CALORIES_LIST_FILE)
    calories_groups = separate_list_by_empty_entry(calories_list)

    calories_per_elf = [sum([int(cal) for cal in calories_group]) for calories_group in calories_groups]

    # Part 1: Find the elf carrying the most calories
    print(f"Elf #{np.argmax(calories_per_elf)} has the most Calories: {np.max(calories_per_elf)}")

    # Part 2: Find the top three elves carrying the most calories
    calories_per_elf_sorted = np.flip(np.sort(calories_per_elf)) # sorted in descending order
    print(f"Top 3 Calories carried: {calories_per_elf_sorted[0]}, {calories_per_elf_sorted[1]}, {calories_per_elf_sorted[2]}")
    print(f"Total Calories carried by top 3: {np.sum(calories_per_elf_sorted[0:3])}")
