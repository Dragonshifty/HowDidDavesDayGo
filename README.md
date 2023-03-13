# How Did Dave's Day Go?

Dave is starting his new job in a pizza restaurant on Tuesday 25th June 1985. The outcome of this program is to find out how his day went. 

Here's a list of the things you will see when you run this program:
- Whether Dave had a good day
- Whether Dave had a bad day

Here's a list of the things that happen that you won't see:
- The day is split into three seperate shifts: Morning, Lunch, and Afternoon.
- Randomly determined amounts of groups will come in to the respective time periods and create food and drinks orders
- Each food order will create specific pizza objects (Factory pattern), using specific Ingredient objects for each pizza that are refilled from stores when necessary
- Each drinks order will create specific cocktail objects (Builder pattern and Factory pattern)
- These orders will be carried out by other staff, such as Chefs and Barkeeps, as well as another waiter, and handed to the waiter to serve
- Each staff member is constructed with different attributes, such as years experience and likeability
- Interactions with each staff will contribute to Dave's mood - he's also particularly fond of on member of staff
- Staff members may be off ill (adding to stress levels)
- Are management in? Staff meetings and fake smiles can be annoying.
- Dave also has likes and dislikes (for instance, he hates anchovies, so serving these kind of pizzas has an adverse effect)

Here's a list of some of the programming elements used:
- Factory pattern
- Builder pattern
- Singleton patterns (Enum and double-lock instances)
- Streams
- Data structures
- Alogithms 
- Encapsulation
- Overloading
- Thread-safety
- Inheritance
- Abstract class vs Interface
