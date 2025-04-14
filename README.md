# Database-organization-final
A todo list made with applying concepts from class, involving binary search tree and merge sort
The application that was made is a to-do list application to help the user maintain their day to day activities with good  efficiency. Users can sort tasks, move them up or down, add, remove them, and update priority. They also have the ability to search for any one of them in less than the blink of an eye and view the history of completed items for reference. Major emphasis on quick access to information, prioritizing at higher levels, and the record of finished items is made.

Three Key Feature it has priority based Sorting: The user can sort the tasks in such a way that the high-priority items are shown first, followed by the lower-priority tasks, all in alphabetical order for easy scanning. It also has a Task Management function that lets the user Add and remove tasks with ease. Archive of Completed Tasks: Every time a user deletes tasks, it does not get deleted completely but instead moves to a "Completed Tasks" log, from where users can look back into their past completed tasks.

Data Structures Used:
1.	ArrayList:
-	The basic data structure for active tasks would be an ArrayList<Task>.
-	It is used because it allows dynamic resizing and easy indexing of tasks. This is very helpful during the insertion and removal operation, showing purposes.
-	Most of all major operations of the application - addition, removal, update priority, relocation of tasks are straightforward with an ArrayList
2.	LinkedList:
-	Completed tasks are stored in a LinkedList<Task>.
-	LinkedList allows for efficient insertion at the tail, and offers a different data structure than the list holding active tasks.
-	It makes sense as an archive: things get appended to it as they are completed. If it ever becomes necessary, this structure can easily be iterated over.
Algorithms Used:
1.	Merge Sort :
-	The sorting is effectively handled by ArrayList.sort(...) which uses an efficient variant of merge sort under the hood.
-	Sorting tasks by their priority and description ensures that we can leverage binary search afterward.
2.	Search Algorithm(Linear Search):
-	If the index matches, perform the specified operation (update or move the task).
-	Compare each index in the loop with the target index provided by the user. If the index matches, perform the specified operation (update or move the task)..

