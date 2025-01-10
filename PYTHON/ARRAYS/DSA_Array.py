class dsa_array:
    Array =[]
    Array1 =[]
    Array2 =[]
    size=0
    size1=0
    size2=0
    maxsize=0
    maxsize1=0
    
    def array_input(self):
        value=True
        while value:
            try:
                self.size=int(input("Please enter the size of First array you want to create\n"))
                self.maxsize=int(input("Please Enter How many elements you will input\n"))
                
                self.size1=int(input("Please enter the size of second  array you want to create\n"))
                self.maxsize1=int(input("Please Enter How many elements you will input\n"))
                
                if type(self.maxsize and self.maxsize1)==int or  type(self.size and self.size1)==int:
                    self.array_creation()
            except ValueError:
                print("Invalid input!")
                self.array_input()

    def array_creation(self):
        i=0
        while i<self.maxsize:
            try:
                elements =int(input("Enter the elements in First Array\t"))
                self.Array.append(elements)
                i+=1
            except IndexError:
                print("re-try")
            except ValueError:
                print(" Input is not an integer. Please enter a valid integer.")
        j=0
        while j<self.maxsize1:
            try:
                elements =int(input("Enter the elements in second array\t"))
                self.Array1.append(elements)
                j+=1
            except IndexError:
                print("re-try")
            except ValueError:
                print(" Input is not an integer. Please enter a valid integer.")
        self.array_option()

    def array_option(self):
        print("choose the Below Methods which you want to perform on Your Created Array:\n")
        print("1.\t Traversing ")
        print("2.\t Insertion ")
        print("3.\t Deleting ")
        print("4.\t Linear - Search ")
        print("5.\t binary - Search ")
        print("6.\t Bubble - Sorting ")
        print("7.\t Sorted - Array ")
        print("8.\t Un - Sorted - Array ")
        print("9.\t Exit \n")
        try:
            option = int (input("Enter the method\n"))
            match option:
                case 1:
                    self.array_traversing()
                case 2:
                    self.array_insertion()
                case 3:
                    self.array_deletion()
                case 4:
                    self.array_linear_search()
                case 5:
                    self.array_binary_search()
                case 6:
                    self.array_Bubble_sorting()
                case 7:
                    self.array_sorted_array()
                case 8:
                    self.array_unsorted_array()
                case 9:
                    exit()
        except ValueError:
            print("Invalid input!")
        print("if you want to continue with other methods in your Created Array\n")
        print("Select Y and if not Select N")
        answer = input()
        if answer == "Y" or answer ==  "y":
            self.array_option()
        else:
            exit()


    def array_traversing(self):
        print("Elements In first Arrays:",self.Array)
        print("\n")
        print("Elements In Second Arrays:",self.Array1)

    def array_insertion(self):
        print("Elements In Arrays:",self.Array)
        n = len(self.Array)
        try:
            print("Enter the number you wanted to inserted in your Created Array:")
            num  = int(input())

            print("Enter the index number in which the element needed to be Inserted:")
            pos  = int(input())

            if pos<0 or pos>n:
                print("invalid position")
                return
            i = n - 1
            self.Array.append(0)
            while (i >= pos):
                self.Array[i + 1] = self.Array[i]
                i-=1

            self.Array[pos] = num
            n+=1
            print("Number Inserted")
            print("Array After insertion",self.Array)
        except ValueError:
            print("Error.")

    def array_deletion(self):
        print("Elements In Arrays:",self.Array)
        n = len(self.Array)
        try:
            print("Enter the index number in which the element needed to be deleted:")
            pos  = int(input())

            if pos<0 or pos>n:
                print("invalid position")
                return

            i=pos
            while i<n-1:
                self.Array[i]=self.Array[i+1]
                i+=1
            self.Array.pop()
            print("Array After Deletion:",self.Array)
        except ValueError:
            print("Error.")


    def array_linear_search(self):
        print("Enter the element you want to find in your Array:")
        try:
            number = int(input())
            i = 0
            flag = 0
            n = len(self.Array)
            while i < n:
                if self.Array[i] == number:
                    flag = 1
                    break
                i += 1
            if flag == 1:
                print("Element found At Index",i)
            else:
                print("Element not found")
        except ValueError:
            print("Error.")

    def array_binary_search(self):
        print("Enter the element you want to find in your Array:")
        try:
            number = int(input())
            start = 0
            end = len(self.Array) - 1

            while start <= end:
                middle = (start + end) // 2
                if self.Array[middle] == number:
                    print(f"The element is found at index: {middle}")
                    break
                elif self.Array[middle] < number:
                    start = middle + 1
                elif self.Array[middle] > number:
                    end = middle - 1
                else:
                    print("Element not found")
        except ValueError:
            print("error.")

    def array_Bubble_sorting(self):
        print("Elements In Arrays Before Bubble Sorting:",self.Array)
        print("\n")
        print("Doing a Bubble Sort in Your Created Array:\n")
        p=0
        size = len(self.Array)
        while p<size-1:
            i=0
            while i<size-p-1:
                if self.Array[i]>self.Array[i+1]:
                    temp = self.Array[i]
                    self.Array[i] = self.Array[i+1]
                    self.Array[i+1] = temp
                i+=1
            p+=1
        print("Elements In Arrays After Bubble Sorting:",self.Array)
        
    def array_sorted_array(self):
        1
    
    def array_unsorted_array(self):
        print("Elements In first Arrays Before merging Array:",self.Array)
        print("\n")
        print("Elements In  second Arrays Before merging Array1:",self.Array1)
        
        self.size2 = self.size + self.size1
        self.Array2 = [None]*self.size2
        i = 0
        while i<self.size:
            self.Array2[i] = self.Array[i]
            i+=1

        j = 0
        while j<self.size1:
            self.Array2[self.size + j] = self.Array1[j]
            j+=1

        print("Elements In  final Arrays after merging Arrays:",self.Array2)
        


da=dsa_array()
da.array_input()